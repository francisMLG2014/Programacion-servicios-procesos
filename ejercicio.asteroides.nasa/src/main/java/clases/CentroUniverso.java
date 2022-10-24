package clases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

public class CentroUniverso {
	private TreeMap<String,ArrayList<Asteroide>> near_earth_objects=
			new TreeMap<String,ArrayList<Asteroide>>();

	public CentroUniverso(TreeMap<String, ArrayList<Asteroide>> near_earth_objects) {
		super();
		this.near_earth_objects = near_earth_objects;
	}

	@Override
	public String toString() {
		String texto="";
		Iterator<String> it=near_earth_objects.keySet().iterator();
		while(it.hasNext()) {
			String fecha=it.next();
			texto+="\n\n\t"+fecha+"\n";
			ArrayList<Asteroide> astersArrayList=this.near_earth_objects.get(fecha);
			for(short i=0;i<astersArrayList.size();i++) {
				texto+=astersArrayList.get(i)+"\n";
			}
		}
		return texto;
	}

	public TreeMap<String, ArrayList<Asteroide>> getNear_earth_objects() {
		return near_earth_objects;
	}

	public void setNear_earth_objects(TreeMap<String, ArrayList<Asteroide>> near_earth_objects) {
		this.near_earth_objects = near_earth_objects;
	}
	
	
}
