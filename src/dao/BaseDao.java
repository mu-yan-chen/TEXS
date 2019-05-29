package dao;
/**
 * 
 *   存在太多的模板代码了
 *
 * 提取出来
 * 
 */

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JdbcUtils;

public class BaseDao {

	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	//通用增删改
	//表和增删改语法  sql
	//赋值参数的个数和类型不一样
	public int executeUpdate(String sql,Object...params){
		int rows=0;
		try {
			conn=JdbcUtils.getConnection();
			ps=conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				ps.setObject(i+1,params[i]);
			}
			rows=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JdbcUtils.close(conn, ps, rs);
		}
		return rows;
		
	}
	
	
	
	public <T> List<T> executeQuery(String sql,Class<T> clz,Object...params){
		List<T>lists=new ArrayList<T>();
		
			try {
				conn = JdbcUtils.getConnection();
				ps = conn.prepareStatement(sql);
				for(int i=0;i<params.length;i++) {
					ps.setObject(i+1, params[i]);
				}
				rs = ps.executeQuery();
				
				ResultSetMetaData md = rs.getMetaData();
				int count = md.getColumnCount();
				
				while(rs.next()){
					T t=clz.newInstance();
					for(int i=0;i<count;i++){
						String name = md.getColumnName(i+1);
						Object value= rs.getObject(name);
						Field field = clz.getDeclaredField(name);
						field.setAccessible(true);
						if(value!=null){
						field.set(t, value);}
					}
					
					
					lists.add(t);
				}
			conn.commit();
			System.out.println("事务已经提交");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			} 
			finally{
				JdbcUtils.close(conn, ps, rs);
			}
		
		
		
		
		return lists;
		
	
	
	}
	
}
