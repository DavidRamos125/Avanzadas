package com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos;

import com.mycompany.aplicacion_de_conceptos.entidades.*;
import com.mycompany.aplicacion_de_conceptos.fabricas.FabricaSistema;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBCursoInscrito implements CRUD<Inscripcion> {
    private FabricaSistema fabrica;
    private Connection connection;

    public DBCursoInscrito() {
        this.fabrica = FabricaSistema.getInstancia();
        try {
            this.connection = fabrica.getConexion().conectar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void crear(Inscripcion objecto) {
        String sql = "INSERT INTO Inscripcion (estudianteID, cursoID, año, semestre) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, objecto.getEstudiante().getID());
            statement.setDouble(2, objecto.getCurso().getID());
            statement.setInt(3, objecto.getAño());
            statement.setInt(4, objecto.getSemestre());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Inscripcion obtener(String id) {
        String[] partes = id.split(",");
        if (partes.length != 4) return null;

        double estudianteID = Double.parseDouble(partes[0]);
        double cursoID = Double.parseDouble(partes[1]);
        int año = Integer.parseInt(partes[2]);
        int semestre = Integer.parseInt(partes[3]);

        String sql = """
        SELECT 
            -- Curso
            c.ID AS cursoID, c.activo AS cursoActivo, c.nombre AS cursoNombre,
            
            -- Programa del curso
            pc.ID AS programaCursoID, pc.nombre AS programaCursoNombre,
            pc.duracion AS programaCursoDuracion, pc.registro AS programaCursoRegistro,
            
            -- Facultad del programa del curso
            fc.ID AS facultadCursoID, fc.nombre AS facultadCursoNombre,
            dp.ID AS decanoCursoID, dp.nombres AS decanoCursoNombres, 
            dp.apellidos AS decanoCursoApellidos, dp.email AS decanoCursoEmail,

            -- Estudiante
            e.ID AS estudianteID, e.codigo, e.activo AS estudianteActivo, e.promedio,
            pe.nombres AS estudianteNombres, pe.apellidos AS estudianteApellidos, pe.email AS estudianteEmail,

            -- Programa del estudiante
            pepr.ID AS programaEstID, pepr.nombre AS programaEstNombre,
            pepr.duracion AS programaEstDuracion, pepr.registro AS programaEstRegistro,

            -- Facultad del programa del estudiante
            fe.ID AS facultadEstID, fe.nombre AS facultadEstNombre,
            de.ID AS decanoEstID, de.nombres AS decanoEstNombres,
            de.apellidos AS decanoEstApellidos, de.email AS decanoEstEmail

        FROM Inscripcion i
        JOIN Curso c ON c.ID = i.cursoID
        JOIN Programa pc ON pc.ID = c.programa_id
        JOIN Facultad fc ON fc.ID = pc.facultad_id
        JOIN Persona dp ON dp.ID = fc.decano_id

        JOIN Estudiante e ON e.ID = i.estudianteID
        JOIN Persona pe ON pe.ID = e.ID
        JOIN Programa pepr ON pepr.ID = e.programa_id
        JOIN Facultad fe ON fe.ID = pepr.facultad_id
        JOIN Persona de ON de.ID = fe.decano_id

        WHERE i.estudianteID = ? AND i.cursoID = ? AND i.año = ? AND i.semestre = ?
    """;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, estudianteID);
            statement.setDouble(2, cursoID);
            statement.setInt(3, año);
            statement.setInt(4, semestre);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                // Decano de facultad del curso
                Persona decanoCurso = FabricaSistema.obtenerPersona(
                        rs.getDouble("decanoCursoID"),
                        rs.getString("decanoCursoNombres"),
                        rs.getString("decanoCursoApellidos"),
                        rs.getString("decanoCursoEmail")
                );
                Facultad facultadCurso = FabricaSistema.obtenerFacultad(
                        rs.getDouble("facultadCursoID"),
                        rs.getString("facultadCursoNombre"),
                        decanoCurso
                );
                Programa programaCurso = FabricaSistema.obtenerPrograma(
                        rs.getDouble("programaCursoID"),
                        rs.getString("programaCursoNombre"),
                        rs.getDouble("programaCursoDuracion"),
                        rs.getString("programaCursoRegistro"),
                        facultadCurso
                );
                Curso curso = FabricaSistema.obtenerCurso(
                        rs.getDouble("cursoID"),
                        rs.getString("cursoNombre"),
                        programaCurso,
                        rs.getBoolean("cursoActivo")
                );

                // Decano de facultad del estudiante
                Persona decanoEst = FabricaSistema.obtenerPersona(
                        rs.getDouble("decanoEstID"),
                        rs.getString("decanoEstNombres"),
                        rs.getString("decanoEstApellidos"),
                        rs.getString("decanoEstEmail")
                );
                Facultad facultadEst = FabricaSistema.obtenerFacultad(
                        rs.getDouble("facultadEstID"),
                        rs.getString("facultadEstNombre"),
                        decanoEst
                );
                Programa programaEst = FabricaSistema.obtenerPrograma(
                        rs.getDouble("programaEstID"),
                        rs.getString("programaEstNombre"),
                        rs.getDouble("programaEstDuracion"),
                        rs.getString("programaEstRegistro"),
                        facultadEst
                );
                Estudiante estudiante = FabricaSistema.obtenerEstudiante(
                        rs.getDouble("estudianteID"),
                        rs.getString("estudianteNombres"),
                        rs.getString("estudianteApellidos"),
                        rs.getString("estudianteEmail"),
                        rs.getDouble("codigo"),
                        programaEst,
                        rs.getBoolean("estudianteActivo"),
                        rs.getDouble("promedio")
                );

                return FabricaSistema.obtenerInscripcion(curso, año, semestre, estudiante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Inscripcion> obtenerTodos() {
        List<Inscripcion> inscripciones = new ArrayList<>();

        String sql = """
        SELECT 
            -- Curso
            c.ID AS cursoID, c.activo AS cursoActivo, c.nombre AS cursoNombre,
            
            -- Programa del curso
            pc.ID AS programaCursoID, pc.nombre AS programaCursoNombre,
            pc.duracion AS programaCursoDuracion, pc.registro AS programaCursoRegistro,
            
            -- Facultad del curso
            fc.ID AS facultadCursoID, fc.nombre AS facultadCursoNombre,
            dp.ID AS decanoCursoID, dp.nombres AS decanoCursoNombres, 
            dp.apellidos AS decanoCursoApellidos, dp.email AS decanoCursoEmail,

            -- Estudiante
            e.ID AS estudianteID, e.codigo, e.activo AS estudianteActivo, e.promedio,
            pe.nombres AS estudianteNombres, pe.apellidos AS estudianteApellidos, pe.email AS estudianteEmail,

            -- Programa del estudiante
            pepr.ID AS programaEstID, pepr.nombre AS programaEstNombre,
            pepr.duracion AS programaEstDuracion, pepr.registro AS programaEstRegistro,

            -- Facultad del estudiante
            fe.ID AS facultadEstID, fe.nombre AS facultadEstNombre,
            de.ID AS decanoEstID, de.nombres AS decanoEstNombres,
            de.apellidos AS decanoEstApellidos, de.email AS decanoEstEmail,

            -- Datos de inscripción
            i.año, i.semestre

        FROM Inscripcion i
        JOIN Curso c ON c.ID = i.cursoID
        JOIN Programa pc ON pc.ID = c.programa_id
        JOIN Facultad fc ON fc.ID = pc.facultad_id
        JOIN Persona dp ON dp.ID = fc.decano_id

        JOIN Estudiante e ON e.ID = i.estudianteID
        JOIN Persona pe ON pe.ID = e.ID
        JOIN Programa pepr ON pepr.ID = e.programa_id
        JOIN Facultad fe ON fe.ID = pepr.facultad_id
        JOIN Persona de ON de.ID = fe.decano_id
    """;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                // Decano y facultad del curso
                Persona decanoCurso = FabricaSistema.obtenerPersona(
                        rs.getDouble("decanoCursoID"),
                        rs.getString("decanoCursoNombres"),
                        rs.getString("decanoCursoApellidos"),
                        rs.getString("decanoCursoEmail")
                );
                Facultad facultadCurso = FabricaSistema.obtenerFacultad(
                        rs.getDouble("facultadCursoID"),
                        rs.getString("facultadCursoNombre"),
                        decanoCurso
                );
                Programa programaCurso = FabricaSistema.obtenerPrograma(
                        rs.getDouble("programaCursoID"),
                        rs.getString("programaCursoNombre"),
                        rs.getDouble("programaCursoDuracion"),
                        rs.getString("programaCursoRegistro"),
                        facultadCurso
                );
                Curso curso = FabricaSistema.obtenerCurso(
                        rs.getDouble("cursoID"),
                        rs.getString("cursoNombre"),
                        programaCurso,
                        rs.getBoolean("cursoActivo")
                );

                // Decano y facultad del estudiante
                Persona decanoEst = FabricaSistema.obtenerPersona(
                        rs.getDouble("decanoEstID"),
                        rs.getString("decanoEstNombres"),
                        rs.getString("decanoEstApellidos"),
                        rs.getString("decanoEstEmail")
                );
                Facultad facultadEst = FabricaSistema.obtenerFacultad(
                        rs.getDouble("facultadEstID"),
                        rs.getString("facultadEstNombre"),
                        decanoEst
                );
                Programa programaEst = FabricaSistema.obtenerPrograma(
                        rs.getDouble("programaEstID"),
                        rs.getString("programaEstNombre"),
                        rs.getDouble("programaEstDuracion"),
                        rs.getString("programaEstRegistro"),
                        facultadEst
                );
                Estudiante estudiante = FabricaSistema.obtenerEstudiante(
                        rs.getDouble("estudianteID"),
                        rs.getString("estudianteNombres"),
                        rs.getString("estudianteApellidos"),
                        rs.getString("estudianteEmail"),
                        rs.getDouble("codigo"),
                        programaEst,
                        rs.getBoolean("estudianteActivo"),
                        rs.getDouble("promedio")
                );

                Inscripcion inscripcion = FabricaSistema.obtenerInscripcion(
                        curso,
                        rs.getInt("año"),
                        rs.getInt("semestre"),
                        estudiante
                );
                inscripciones.add(inscripcion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return inscripciones;
    }


    @Override
    public void actualizar(Inscripcion objeto) {
        throw new UnsupportedOperationException("No se puede actualizar una inscripción. Debe eliminar y crear una nueva.");
    }

    @Override
    public void eliminar(String id) {
        String sql = "DELETE FROM Inscripcion WHERE estudianteID = ? AND cursoID = ? AND año = ? AND semestre = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            String[] partes = id.split(",");
            if (partes.length != 4) {
                throw new IllegalArgumentException("Formato de ID inválido. Se espera: 'estudianteID,cursoID,año,semestre'");
            }

            statement.setDouble(1, Double.parseDouble(partes[0])); // estudianteID
            statement.setDouble(2, Double.parseDouble(partes[1])); // cursoID
            statement.setInt(3, Integer.parseInt(partes[2]));      // año
            statement.setInt(4, Integer.parseInt(partes[3]));      // semestre

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir los valores del ID: " + e.getMessage());
        }
    }
}
