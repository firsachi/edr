package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import parser.Ufop;

public class SubjectDao {

	public void create(Ufop ufop, DataSourse ds) {
		String sql = "INSERT INTO ufop (edrpou,opf,short_name,stan) VALUES (?,?,?,?)";
		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setString(1, ufop.getEdrpou());
			ps.setString(2, ufop.getOpf());
			ps.setString(3, ufop.getShortName());
			ps.setString(4, ufop.getStan());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
