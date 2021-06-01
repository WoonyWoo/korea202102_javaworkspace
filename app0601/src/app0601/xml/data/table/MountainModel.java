package app0601.xml.data.table;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

//JTable이 각종 정보를 참조해서 표를 구현할 수 있도록 데이터를 제공해주는 객체
public class MountainModel extends AbstractTableModel{
	Vector<Mountain> data = new Vector<Mountain>();
	Vector<String> column = new  Vector<String>();
	
	public MountainModel() {
		String[] title = {"산 소재지","상세설명","산 높이","일련번호","산 이름"};
		for(String data : title) {
			column.add(data);
		}
	}
	
	public int getRowCount() {
		return data.size();
	}

	public int getColumnCount() {
		return column.size();
	}

	public String getColumnName(int col) {
		return column.get(col);
	}
	
	public Object getValueAt(int row, int col) {
		Mountain mt = data.get(row); //벡터에서 VO 하나 끄집어 내기!!
		String value = null; //각 셀에 들어갈 데이터
		
		if(col==0) {
			value = mt.getMntiadd();
		}else if(col==1) {
			value = mt.getMntidetails();
		}else if(col==2) {
			value = mt.getMntihigh();
		}else if(col==3) {
			value = Integer.toString(mt.getMntilistno());
		}else if(col==4) {
			value = mt.getMntiname();
		}
		
		return value;
	}

}
