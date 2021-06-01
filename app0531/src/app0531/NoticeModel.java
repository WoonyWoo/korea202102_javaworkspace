package app0531;

import java.util.Vector;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

//notice 게시판 전용 TableModel
public class NoticeModel extends AbstractTableModel{
	Vector<Notice> data = new Vector<Notice>(); //기존의 데이터를 처리했던 이차원배열을 대신한 컬렉션 객체
	Vector<String> column = new Vector<String>(); //기존의 컬럼명을 처리했던 일차원배열을 대신할 컬렉션 객체
	
	public int getRowCount() {
		return data.size(); //VO가 담겨진 벡터의 크기
	}

	public int getColumnCount() {
		return column.size();
	}
	
	//이 메서드는 getColumnCount() 의 반환값만큼 호출하면서 매개변수의 col의 값을 0부터 증가시키며 호출
	public String getColumnName(int col) {
		return column.get(col); //0,1,2,3... 순서대로 col을 증가시키며 호출
	}

	public Object getValueAt(int row, int col) {
		//row로 벡터의 index를 접근한다!!
		String value=null;
		Notice notice = data.get(row);
		
		if(col==0) {
			value = Integer.toString(notice.getNotice_id());
		}else if(col==1) {
			value = notice.getTitle();
		}else if(col==2) {
			value = notice.getWriter();
		}else if(col==3) {
			value = notice.getContent();
		}else if(col==4) {
			value = notice.getRegdate();
		}else if(col==5) {
			value = Integer.toString(notice.getHit());
		}
		
		return value;
	}
}
