package com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos;

import com.mycompany.aplicacion_de_conceptos.entidades.Curso;
import com.mycompany.aplicacion_de_conceptos.entidades.CursoProfesor;
import com.mycompany.aplicacion_de_conceptos.entidades.Profesor;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class DBCursoProfesor implements CRUD<CursoProfesor> {
    private Connection connection;

    public DBCursoProfesor(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(CursoProfesor objecto) {
        String sql = "INSERT INTO CursoProfesor (cursoID, profesorID) VALUES (BIGINT, BIGINT)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, objecto.curso.ID);
            statement.setInt(2, objecto.profesor.ID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CursoProfesor obtener(String id) {
        String sql = "SELECT * FROM CursoProfesor WHERE profesorID = BIGINT";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Curso curso = new Curso(rs.getInt("cursoID"), null, true);
                Profesor profesor = new Profesor(rs.getInt("profesorID"), "", "");
                return new CursoProfesor(curso, profesor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CursoProfesor> obtenerTodos() {
        List<CursoProfesor> lista = new ArrayList<>();
        String sql = "SELECT * FROM CursoProfesor";
        try (Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                Curso curso = new Curso(rs.getInt("cursoID"), null, true);
                Profesor profesor = new Profesor(rs.getInt("profesorID"), "", "");
                lista.add(new CursoProfesor(curso, profesor));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void actualizar(CursoProfesor objecto) {
        String sql = "UPDATE CursoProfesor SET cursoID = BIGINT WHERE profesorID = BIGINT";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, objecto.curso.ID);
            statement.setInt(2, objecto.profesor.ID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(String id) {
        String sql = "DELETE FROM CursoProfesor WHERE profesorID = BIGINT";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}