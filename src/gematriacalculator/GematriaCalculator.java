package gematriacalculator;

public class GematriaCalculator {
	public GematriaMethod[] methods;

	public GematriaCalculator() {
		methods = new GematriaMethod[11];
		methods[0] = new GematriaMethodAbsolute();
		methods[1] = new GematriaMethodAbsoluteSofit();
		methods[2] = new GematriaMethodOrdinal();
		methods[3] = new GematriaMethodOrdinalSofit();
		methods[4] = new GematriaMethodReduced();
		methods[5] = new GematriaMethodReducedSofit();
		methods[6] = new GematriaMethodIntegralReduced();
		methods[7] = new GematriaMethodIntegralReducedSofit();
		methods[8] = new GematriaMethodAtbash();
		methods[9] = new GematriaMethodAlbam();
		methods[10] = new GematriaMethodAvgad();
	}
}