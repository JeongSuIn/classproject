package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Scanner;

public class emp_practice {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);

		Connection conn = null;

		try {
			// 1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");

			System.out.println("Oracle Driver Load !!!");

			// 2. DB 연결 localhost==127.0.0.1
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "tiger";

			conn = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("데이터베이스에 접속했습니다.");

			// 3. statement 인스턴스 생성
			Statement stmt = conn.createStatement();

//			System.out.println("새로 입사한 사원의 사원번호를 입력해주세요.");
//			int empNo = sc.nextInt();
//			System.out.println("새로 입사한 사원의 이름을 입력해주세요.");
//			String empName = sc.nextLine();
//			System.out.println("새로 입사한 사원의 이름을 입력해주세요.");
//			String empName = sc.nextLine();

			// 입력
			String sqlInsert = "insert into emp values(7999, 'ALI', 'MANAGER', 7902, '20/11/18', 9000, 0, 10)";

			int resultCnt = stmt.executeUpdate(sqlInsert);

			if (resultCnt > 0) {
				System.out.println("데이터가 정상적으로 입력되었습니다.");
			}

			// 4. sql 실행: 사원 리스트 출력
			String sql = "select * from emp order by empno";

			ResultSet rs = stmt.executeQuery(sql);

			// 5. ResultSet을 이용해서 결과 출력
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String empname = rs.getString("empname");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
						

				System.out.println(empno + "\t" + empname + "\t" + job + "\t"+ mgr+ "\t" + hiredate+ "\t"+ sal+ "\t"+ comm + "\t"+ deptno );
			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (ClassNotFoundException e) {

			System.out.println("Driver 로드 실패");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
