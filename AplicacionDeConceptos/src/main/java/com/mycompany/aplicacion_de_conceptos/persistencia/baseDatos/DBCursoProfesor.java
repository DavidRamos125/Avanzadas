package com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos;

import com.mycompany.aplicacion_de_conceptos.entidades.*;
import com.mycompany.aplicacion_de_conceptos.fabricas.FabricaSistema;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class DBCursoProfesor implements CRUD<CursoProfesor> {

    private FabricaSistema fabrica;
    private Connection connection;

    public DBCursoProfesor() {
        this.fabrica = FabricaSistema.getInstancia();
        try {
            this.connection = fabrica.getConexion().conectar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void crear(CursoProfesor objecto) {
        String sql = "INSERT INTO CursoProfesor (cursoID, profesorID) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, objecto.getCurso().getID());
            statement.setDouble(2, objecto.getProfesor().getID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CursoProfesor obtener(String id) {
        String sql = """
        SELECT cp.*, 
               c.ID AS curso_id, c.nombre AS curso_nombre, c.programaID,
               p.ID AS profesor_id, p.tipo_contrato,
               per_prof.nombres, per_prof.apellidos, per_prof.email,

               prg.nombre AS programa_nombre, prg.duracion, prg.registro, 
               f.ID AS facultad_id, f.nombre AS facultad_nombre,
               per_decano.ID AS decano_id, per_decano.nombres AS decano_nombres, 
               per_decano.apellidos AS decano_apellidos, per_decano.email AS decano_email,
               prof_decano.tipo_contrato AS decano_tipo_contrato

        FROM CursoProfesor cp
        JOIN Curso c ON cp.cursoID = c.ID
        JOIN Profesor p ON cp.profesorID = p.ID
        JOIN Persona per_prof ON p.ID = per_prof.ID
        JOIN Programa prg ON c.programaID = prg.ID
        JOIN Facultad f ON prg.facultad_id = f.ID
        JOIN Profesor prof_decano ON f.decanoID = prof_decano.ID
        JOIN Persona per_decano ON prof_decano.ID = per_decano.ID
        WHERE cp.profesorID = ?
    """;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, Double.parseDouble(id));
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                // Crear decano
                Persona decano = FabricaSistema.obtenerProfesor(
                        rs.getDouble("decano_id"),
                        rs.getString("decano_nombres"),
                        rs.getString("decano_apellidos"),
                        rs.getString("decano_email"),
                        rs.getString("decano_tipo_contrato")
                );

                // Crear facultad
                Facultad facultad = FabricaSistema.obtenerFacultad(
                        rs.getDouble("facultad_id"),
                        rs.getString("facultad_nombre"),
                        decano
                );

                // Crear programa
                Programa programa = FabricaSistema.obtenerPrograma(
                        rs.getDouble("programaID"),
                        rs.getString("programa_nombre"),
                        rs.getInt("duracion"),
                        rs.getString("registro"),
                        facultad
                );

                // Crear curso
                Curso curso = FabricaSistema.obtenerCurso(
                        rs.getDouble("curso_id"),
                        rs.getString("curso_nombre"),
                        programa,
                        true
                );

                // Crear profesor
                Profesor profesor = FabricaSistema.obtenerProfesor(
                        rs.getDouble("profesor_id"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("email"),
                        rs.getString("tipo_contrato")
                );

                // Crear y retornar CursoProfesor
                return FabricaSistema.obtenerCursoProfesor(
                        profesor,
                        rs.getInt("año"),
                        rs.getInt("semestre"),
                        curso
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<CursoProfesor> obtenerTodos() {
        List<CursoProfesor> lista = new ArrayList<>();
        String sql = "SELECT cp.*, " +
                "c.nombre AS curso_nombre, c.programa_id, c.activo AS curso_activo, " +
                "p.nombres AS profesor_nombres, p.apellidos AS profesor_apellidos, p.email AS profesor_email, " +
                "pr.tipo_contrato, " +
                "prog.ID AS programa_id, prog.nombre AS programa_nombre, prog.duracion, prog.registro, " +
                "f.ID AS facultad_id, f.nombre AS facultad_nombre, " +
                "d.ID AS decano_id, d.nombres AS decano_nombres, d.apellidos AS decano_apellidos, d.email AS decano_email " +
                "FROM CursoProfesor cp " +
                "JOIN Curso c ON cp.cursoID = c.ID " +
                "JOIN Programa prog ON c.programa_id = prog.ID " +
                "JOIN Facultad f ON prog.facultad_id = f.ID " +
                "JOIN Persona d ON f.decano_id = d.ID " +
                "JOIN Profesor pr ON cp.profesorID = pr.ID " +
                "JOIN Persona p ON pr.ID = p.ID";

        try (Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                Persona decano = FabricaSistema.obtenerPersona(
                        rs.getDouble("decano_id"),
                        rs.getString("decano_nombres"),
                        rs.getString("decano_apellidos"),
                        rs.getString("decano_email")
                );

                Facultad facultad = FabricaSistema.obtenerFacultad(
                        rs.getDouble("facultad_id"),
                        rs.getString("facultad_nombre"),
                        decano
                );

                Programa programa = FabricaSistema.obtenerPrograma(
                        rs.getDouble("programa_id"),
                        rs.getString("programa_nombre"),
                        rs.getDouble("duracion"),
                        rs.getString("registro"),
                        facultad
                );

                Curso curso = FabricaSistema.obtenerCurso(
                        rs.getDouble("cursoID"),
                        rs.getString("curso_nombre"),
                        programa,
                        rs.getBoolean("curso_activo")
                );

                Profesor profesor = FabricaSistema.obtenerProfesor(
                        rs.getDouble("profesorID"),
                        rs.getString("profesor_nombres"),
                        rs.getString("profesor_apellidos"),
                        rs.getString("profesor_email"),
                        rs.getString("tipo_contrato")
                );

                CursoProfesor cursoProfesor = FabricaSistema.obtenerCursoProfesor(
                        profesor,
                        rs.getInt("año"),
                        rs.getInt("semestre"),
                        curso
                );

                lista.add(cursoProfesor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void actualizar(CursoProfesor objecto) {
        String sql = "UPDATE CursoProfesor SET cursoID = ? " +
                "WHERE profesorID = ? AND año = ? AND semestre = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, objecto.getCurso().getID());
            statement.setDouble(2, objecto.getProfesor().getID());
            statement.setInt(3, objecto.getAño());
            statement.setInt(4, objecto.getSemestre());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(String id) {
        String sql = "DELETE FROM CursoProfesor WHERE profesorID = ? AND cursoID = ? AND año = ? AND semestre = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            String[] partes = id.split(",");
            if (partes.length == 4) {
                double profesorID = Double.parseDouble(partes[0]);
                double cursoID = Double.parseDouble(partes[1]);
                int año = Integer.parseInt(partes[2]);
                int semestre = Integer.parseInt(partes[3]);

                statement.setDouble(1, profesorID);
                statement.setDouble(2, cursoID);
                statement.setInt(3, año);
                statement.setInt(4, semestre);

                statement.executeUpdate();
            } else {
                System.err.println("ID mal formado. Debe tener el formato: 'profesorID,cursoID,año,semestre'");
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
