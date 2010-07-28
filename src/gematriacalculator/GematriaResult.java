package gematriacalculator;

import java.util.ArrayList;

public class GematriaResult {
	public String word;
	public ArrayList<GematriaResultType> results;

	public GematriaResult(String word) {
		this.word = word;
		this.results = new ArrayList<GematriaResultType>();
		
		results.add(new GematriaResultTypeAbsolute(word));
		results.add(new GematriaResultTypeOrdinal(word));
		results.add(new GematriaResultTypeReduced(word));
		results.add(new GematriaResultTypeIntegralReduced(word));
		results.add(new GematriaResultTypeAtbash(word));
		results.add(new GematriaResultTypeAlbam(word));
		results.add(new GematriaResultTypeAvgad(word));
	}
}