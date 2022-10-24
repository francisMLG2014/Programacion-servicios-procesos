package pruebas.api.rest;

public class Info {
	private String seed;
	private int results;
	private byte page;
	private String version;
	public Info(String seed, int results, byte page, String version) {
		super();
		this.seed = seed;
		this.results = results;
		this.page = page;
		this.version = version;
	}
	public String getSeed() {
		return seed;
	}
	public void setSeed(String seed) {
		this.seed = seed;
	}
	public int getResults() {
		return results;
	}
	public void setResults(int results) {
		this.results = results;
	}
	public byte getPage() {
		return page;
	}
	public void setPage(byte page) {
		this.page = page;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "Info [seed=" + seed + ", results=" + results + ", page=" + page + ", version=" + version + "]";
	}

	
}
