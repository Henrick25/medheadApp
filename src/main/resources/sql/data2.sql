-- Adaptation de la procédure stockée pour H2
CREATE ALIAS find_nearest_hospital AS $$

findNearestHospital(Connection conn, String specialisationName, double lat, double lon) throws SQLException {
    String sql = "SELECT hospital.id, hospital.name, hospital.latitude, hospital.longitude, hospital.lit, hospital.numeroderue, hospital.nomdelarue, hospital.postal, (6371 * acos(cos(radians(?)) * cos(radians(hospital.latitude)) * cos(radians(hospital.longitude) - radians(?)) + sin(radians(?)) * sin(radians(hospital.latitude)))) AS distance FROM Hospital hospital JOIN HospitalSpecialization hs ON hospital.id = hs.hospital_id JOIN Specialization sp ON hs.specialization_id = sp.id WHERE sp.name = ? AND hospital.lit >= 1 ORDER BY distance ASC LIMIT 1";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setDouble(1, lat);
    stmt.setDouble(2, lon);
    stmt.setDouble(3, lat);
    stmt.setString(4, specialisationName);
    ResultSet rs = stmt.executeQuery();
    while (rs.next()) {
        // Traitez le résultat comme nécessaire
    }
}
$$;
