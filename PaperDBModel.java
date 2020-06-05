package assign5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * This class takes in a bunch of ResearchPaper objects and organizes and processes them
 * so that they may be displayed.  
 */
public class PaperDBModel {
	
	private HashMap<String, ResearchPaper>            byTitle;  //in essence, the master list of papers. 
																//If the paper exists anywhere in the DB, it will exist here
	private HashMap<String, ArrayList<ResearchPaper>> byAuthor;
	private HashMap<String, ArrayList<ResearchPaper>> byConference;
	private HashMap<String, ArrayList<ResearchPaper>> byKeyword;

	//Q1 Constructor
	public PaperDBModel() {
		//TODO: instantiate all the member variables
		byTitle = new HashMap<String, ResearchPaper>();
		byAuthor = new HashMap<String, ArrayList<ResearchPaper>>();
		byConference = new HashMap<String, ArrayList<ResearchPaper>>();
		byKeyword = new HashMap<String, ArrayList<ResearchPaper>>();
	}

	//Q2 Getter
	public ResearchPaper getResearchPaper(String title) {
		//TODO: finish this method.
		ResearchPaper p = byTitle.get(title);
		if (p == null)
			return null;
		return p;
	}

	public ArrayList<ResearchPaper> getPapersByAuthor(String author){
		//TODO: finish this method.
		ArrayList<ResearchPaper> p = byAuthor.get(author);
		if (p == null)
			return null;
		return p;
	}

	public ArrayList<ResearchPaper> getPapersByConference(String conference){
		//TODO: finish this method. 
		ArrayList<ResearchPaper> p = byConference.get(conference);
		if (p == null)
			return null;
		return p;
	}

	public ArrayList<ResearchPaper> getPapersByKeyword(String keyword){
		//TODO: finish this method. 
		ArrayList<ResearchPaper> p = byKeyword.get(keyword);
		if (p == null)
			return null;
		return p;
	}


	//Q3 add and remove Research Paper
	/**
	 * Complete this method by putting the new paper in byTitle,
	 * byAuthor, byConference, and byKeyword HashMaps.
	 * @param paper is the ResearchPaper to add
	 */
	public void addResearchPaper(ResearchPaper paper) {
		//TODO: add this paper in every appropriate Collection
		//byTitle
		byTitle.put(paper.getTitle(), paper);

		//byAuthor
		for (String a: paper.getAuthors()){
			if (!byAuthor.containsKey(a))
				byAuthor.put(a, new ArrayList<ResearchPaper>());
			byAuthor.get(a).add(paper);
		}

		//byConference
		if (!byConference.containsKey(paper.getConference()))
			byConference.put(paper.getConference(), new ArrayList<ResearchPaper>());
		byConference.get(paper.getConference()).add(paper);

		//byKeyword
		for (String k: paper.getKeywords()){
			if (!byKeyword.containsKey(k))
				byKeyword.put(k, new ArrayList<ResearchPaper>());
			byKeyword.get(k).add(paper);
		}

	}

	/**
	 * Remove every instance of this paper from the database.
	 * @param paper
	 */
	public void removeResearchPaper(ResearchPaper paper) {
		//TODO: remove this paper from every appropriate Collection

		//byTitle
		byTitle.remove(paper.getTitle());

		//byAuthor
		for (String a: paper.getAuthors()){
			byAuthor.get(a).remove(paper);
			if (byAuthor.get(a).isEmpty())
				byAuthor.remove(a);
		}

		//byConference
		byConference.get(paper.getConference()).remove(paper);
		if (byConference.get(paper.getConference()).isEmpty())
			byConference.remove(paper.getConference());

		//byKeyword
		for (String k: paper.getKeywords()){
			byKeyword.get(k).remove(paper);
			if (byKeyword.get(k).isEmpty())
				byKeyword.remove(k);
		}

	}

	//Q4 getPapersByAuthorAndConference & getPapersByAuthors
	public ArrayList<ResearchPaper> getPapersByAuthorAndConference(String author, String conference){
		//TODO: Return an ArrayList of all the papers that have the author
		//given and were published in the conference give,
		//or an empty ArrayList if there are no papers.
		ArrayList<ResearchPaper> papers = new ArrayList<ResearchPaper>();
		if (byAuthor.containsKey(author)){
			for (ResearchPaper p: byAuthor.get(author))
				papers.add(p);
		}
		if (byConference.containsKey(conference)){
			for (ResearchPaper pp : byConference.get(conference))
				papers.add(pp);
		}
		if (papers == null)
			return null;
		return papers;
	}

	public ArrayList<ResearchPaper> getPapersByAuthors(String ... authors){
		//TODO: return all papers with ALL the authors listed, or an empty list otherwise.
		//That is, if the authors are "Steve", "Helga", every paper returned should have
		//both authors listed.
		ArrayList<ResearchPaper> papers = new ArrayList<ResearchPaper>();
		for (int i=0;i<authors.length;i++){
			System.out.println("---------------------------------------"+authors[i]);
			try {
				for (ResearchPaper p: byAuthor.get(authors[i])) {
					if (p != null) {
						papers.add(p);
					}
				}
			}catch (NullPointerException e){
				if (papers.size() != 0){
					return papers;
				}else {
					return null;
				}
			}

		}
		return papers;
	}
	
	//generic getter methods
	public HashMap<String, ResearchPaper> getPapersByTitle(){
		return byTitle;
	}
	
	public HashMap<String, ArrayList<ResearchPaper>> getPapersByAuthor(){
		return byAuthor;
	}
	
	public HashMap<String, ArrayList<ResearchPaper>> getPapersByConference(){
		return byConference;
	}
	
	public HashMap<String, ArrayList<ResearchPaper>> getPapersByKeyword(){
		return byKeyword;
	}
	
	
	/**
	 * This will help you test by providing some papers you can load from a file and test
	 * your methods on.
	 * @param args
	 */
	//Q5 Write tests for the methods above.
	// from Q2 - getResearchPaper / getPapersByAuthor / getPapersByConference / getPapersByKeyword
	// from Q3 - AddResearchPaper / RemoveResearchPaper
	// from Q4 - getPapersByAuthorAndConference / getPapersByAuthors
	public static void main(String[] args) {
		PaperDBModel model = new PaperDBModel();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("papers.txt"));
			String line = reader.readLine();
			while (line != null) {
				//this is a comment line or an empty line
				if (line.startsWith("#")||line.trim().length()==0) {
					line = reader.readLine();
					continue;
				}
				
				// if anything is there, we assume it is a well formed
				// record. No error checking is done.
				model.addResearchPaper(getResearchPaper(line, reader));
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//TODO: papers are loaded, write tests
		System.out.println("Here are the Research Papers in our model right now: ");
		//This simply prints out every paper
		for(ResearchPaper paper: model.byTitle.values()) {
			System.out.println(paper);
		}

		//getPapersByAuthorAndConference
		System.out.println("Let's Test getPapersByAuthorAndConference");
		System.out.println("Author Cindy's papers or papers by Conference Skynet conference: ");
		System.out.println(model.getPapersByAuthorAndConference("Cindy", "Skynet conference"));
		System.out.println("Author Cindy's papers under Conference CU: ");
		System.out.println(model.getPapersByAuthorAndConference("Cindy", "CU"));

		//getPapersByAuthors 有问题，没有找到所有author的paper，只找到第一个的
		System.out.println("======================================================");
		System.out.println("Let's Test getPapersByAuthors");
		System.out.println("Author Cindy and Bobby wrote papers ");
		System.out.println(model.getPapersByAuthors("Cindy","Bobby"));
		System.out.println("Author Cindy and Mia wrote papers ");
		System.out.println(model.getPapersByAuthors("Cindy", "Mia"));

		//RemoveResearchPaper
		System.out.println("======================================================");
		System.out.println("Let's Test RemoveResearchPaper");
		System.out.println("Remove <How to survive first year comp sci>");
		model.removeResearchPaper(model.getResearchPaper("How to survive first year comp sci"));
		System.out.println("Now search paper <How to survive first year comp sci>: ");
		System.out.println(model.getResearchPaper("How to survive first year comp sci"));

		//AddResearchPaper
		System.out.println("======================================================");
		System.out.println("Let's Test AddResearchPaper");
		System.out.println("Add paper <How to survive first year comp sci> back ");
		ArrayList<String> a1 = new ArrayList<String>();
		a1.add("123");
		a1.add("asd");
		ArrayList<String> kw = new ArrayList<String>();
		kw.add("xxx");
		kw.add("zzz");
		model.addResearchPaper(new ResearchPaper("whatever",a1,kw,"who know"));
		System.out.println("Now search paper <whatever>: ");
		System.out.println(model.getResearchPaper("whatever"));

		//getResearchPaper
		System.out.println("======================================================");
		System.out.println("Let's Test getResearchPaper");
		System.out.println("Get <Useless graphs and how to draw them>");
		System.out.println(model.getResearchPaper("Useless graphs and how to draw them"));
		System.out.println("Get <I love COMP>");
		System.out.println(model.getResearchPaper("Get <I love COMP>"));


		//getPapersByAuthor
		System.out.println("======================================================");
		System.out.println("Let's Test getPapersByAuthor");
		System.out.println("Get Cindy's paper: ");
		System.out.println(model.getPapersByAuthor("Cindy"));
		System.out.println("Get Mia's paper: ");
		System.out.println(model.getPapersByAuthor("Mia"));


		//getPapersByConference
		System.out.println("======================================================");
		System.out.println("Let's Test getPapersByConference");
		System.out.println("Get papers under conference Skynet conference: ");
		System.out.println(model.getPapersByConference("Skynet conference"));
		System.out.println("Get papers under conference CU: ");
		System.out.println(model.getPapersByConference("CU"));

		//getPapersByKeyword
		System.out.println("======================================================");
		System.out.println("Let's Test getPapersByKeyword");
		System.out.println("Papers with key word apocalypse: ");
		System.out.println(model.getPapersByKeyword("apocalypse"));
		System.out.println("Papers with key word fun: ");
		System.out.println(model.getPapersByKeyword("fun"));

		//TODO: write more tests if you want

	}
	
	/**
	 * The assumption is that the next line in the reader starts the ResearchPaper record.
	 * First line: title
	 * Second line: authors separated by commas
	 * Third line: keywords separated by commas
	 * Fourth line: conference
	 * @param reader
	 * @return
	 */
	private static ResearchPaper getResearchPaper(String line, BufferedReader reader) throws IOException{
		String title = line.trim();
		String[] authors = reader.readLine().split(",");
		ArrayList<String> auths = new ArrayList<>();
		for (String auth: authors) {
			auths.add(auth.trim());
		}
		String[] keywords = reader.readLine().split(",");
		ArrayList<String> keywordList = new ArrayList<>();
		for (String keyw: keywords) {
			keywordList.add(keyw.trim());
		}
		String conf = reader.readLine().trim();
		
		return new ResearchPaper(title, auths, keywordList, conf);
		
	}	
	
	

}
