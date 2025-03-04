package com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos;

import com.mycompany.aplicacion_de_conceptos.entidades.Curso;
import com.mycompany.aplicacion_de_conceptos.entidades.Estudiante;
import com.mycompany.aplicacion_de_conceptos.entidades.Inscripcion;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBCursoInscrito implements CRUD<Inscripcion> {
    private Connection connection;
    
    public DBCursoInscrito(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void crear(Inscripcion objecto) {
        String sql = "INSERT INTO Inscripcion (cursoID, año, semestre, estudianteID) VALUES (BIGINT, INT, INT, BIGINT)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, objecto.cursoID());
            statement.setInt(2, objecto.año());
            statement.setInt(3, objecto.semestre());
            statement.setDouble(4, objecto.estudianteID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Inscripcion obtener(String id) {
        String sql = "SELECT * FROM Inscripcion WHERE estudianteID = BIGINT";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Curso curso = new Curso(rs.getInt("cursoID"), null, true);
                Estudiante estudiante = new Estudiante(rs.getDouble("estudianteID"), "", "", "", 0, null, true, 0);
                return new Inscripcion(curso, rs.getInt("año"), rs.getInt("semestre"), estudiante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Inscripcion> obtenerTodos() {
        List<Inscripcion> lista = new ArrayList<>();
        String sql = "SELECT * FROM Inscripcion";
        try (Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                Curso curso = new Curso(rs.getInt("cursoID"), null, true);
                Estudiante estudiante = new Estudiante(rs.getDouble("estudianteID"), "", "", "", 0, null, true, 0);
                lista.add(new Inscripcion(curso, rs.getInt("año"), rs.getInt("semestre"), estudiante));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void actualizar(Inscripcion objecto) {
        String sql = "UPDATE Inscripcion SET cursoID = BIGINT, año = INT , semestre = INT WHERE estudianteID = BIGINT";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, objecto.getCurso().getID());
            statement.setInt(2, objecto.getAño());
            statement.setInt(3, objecto.getSemestre());
            statement.setDouble(4, objecto.getEstudiante().getID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(String id) {
        String sql = "DELETE FROM Inscripcion WHERE estudianteID = BIGINT";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
