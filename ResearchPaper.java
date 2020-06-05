package researchmodel;

import java.util.ArrayList;

public class ResearchPaper {
	
	private String title;
	private ArrayList<String> authors;
	private ArrayList<String> keywords;
	private String conference;
	
	
	
	public ResearchPaper(String title, ArrayList<String> authors, ArrayList<String> keywords, String conference) {
		this.title = title;
		this.authors = authors;
		this.keywords = keywords;
		this.conference = conference;
	}

	


	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public ArrayList<String> getAuthors() {
		return authors;
	}




	public void setAuthors(ArrayList<String> authors) {
		this.authors = authors;
	}




	public ArrayList<String> getKeywords() {
		return keywords;
	}




	public void setKeywords(ArrayList<String> keywords) {
		this.keywords = keywords;
	}




	public String getConference() {
		return conference;
	}




	public void setConference(String conference) {
		this.conference = conference;
	}

	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("Title:      "+title);
		buf.append("\nAuthors:    ");
		for (String author: authors) {
			buf.append(author);
			buf.append(", ");
		}
		buf.delete(buf.length()-2,buf.length()-1);
		buf.append("\nKeywords:   ");
		for (String keyword: keywords) {
			buf.append(keyword);
			buf.append(", ");
		}
		buf.delete(buf.length()-2,buf.length()-1);
		buf.append("\nConference: "+conference+"\n");
		return buf.toString();

	}

	public static void main(String[] args) {
		
	}
}
