import java.util.*;

public class Calculator {
	private String result, stats, error;
	private final int Pokemon[][] = {
			{90, 126, 126},
			{120, 156, 158},
			{160, 198, 200},
			{78, 128, 108},
			{116, 160, 140},
			{156, 212, 182},
			{88, 112, 142},
			{118, 144, 176},
			{158, 186, 222},
			{90, 62, 66},
			{100, 56, 86},
			{120, 144, 144},
			{80, 68, 64},
			{90, 62, 82},
			{130, 144, 130},
			{80, 94, 90},
			{126, 126, 122},
			{166, 170, 166},
			{60, 92, 86},
			{110, 146, 150},
			{80, 102, 78},
			{130, 168, 146},
			{70, 112, 112},
			{120, 166, 166},
			{70, 124, 108},
			{120, 200, 154},
			{100, 90, 114},
			{150, 150, 172},
			{110, 100, 104},
			{140, 132, 136},
			{180, 184, 190},
			{92, 110, 94},
			{122, 142, 128},
			{162, 204, 170},
			{140, 116, 124},
			{190, 178, 178},
			{76, 106, 118},
			{146, 176, 194},
			{230, 98, 54},
			{280, 168, 108},
			{80, 88, 90},
			{150, 164, 164},
			{90, 134, 130},
			{120, 162, 158},
			{150, 202, 190},
			{70, 122, 120},
			{120, 162, 170},
			{120, 108, 118},
			{140, 172, 154},
			{20, 108, 86},
			{70, 148, 140},
			{80, 104, 94},
			{130, 156, 146},
			{100, 132, 112},
			{160, 194, 176},
			{80, 122, 96},
			{130, 178, 150},
			{110, 156, 110},
			{180, 230, 180},
			{80, 108, 98},
			{130, 132, 132},
			{180, 180, 202},
			{50, 110, 76},
			{80, 150, 112},
			{110, 186, 152},
			{140, 118, 96},
			{160, 154, 144},
			{180, 198, 180},
			{100, 158, 78},
			{130, 190, 110},
			{160, 222, 152},
			{80, 106, 136},
			{160, 170, 196},
			{80, 106, 118},
			{110, 142, 156},
			{160, 176, 198},
			{100, 168, 138},
			{130, 200, 170},
			{180, 110, 110},
			{190, 184, 198},
			{50, 128, 138},
			{100, 186, 180},
			{104, 138, 132},
			{70, 126, 96},
			{120, 182, 150},
			{130, 104, 138},
			{180, 156, 192},
			{160, 124, 110},
			{210, 180, 188},
			{60, 120, 112},
			{100, 196, 196},
			{60, 136, 82},
			{90, 172, 118},
			{120, 204, 156},
			{70, 90, 186},
			{120, 104, 140},
			{170, 162, 196},
			{60, 116, 110},
			{110, 178, 168},
			{80, 102, 124},
			{120, 150, 174},
			{120, 110, 132},
			{190, 232, 164},
			{100, 102, 150},
			{120, 140, 202},
			{100, 148, 172},
			{100, 138, 204},
			{180, 126, 160},
			{80, 136, 142},
			{130, 190, 198},
			{160, 110, 116},
			{210, 166, 160},
			{500, 40, 60},
			{130, 164, 152},
			{210, 142, 178},
			{60, 122, 100},
			{110, 176, 150},
			{90, 112, 126},
			{160, 172, 160},
			{60, 130, 128},
			{120, 194, 192},
			{80, 154, 196},
			{140, 176, 180},
			{130, 172, 134},
			{130, 198, 160},
			{130, 214, 158},
			{130, 184, 186},
			{150, 148, 184},
			{40, 42, 84},
			{190, 192, 196},
			{260, 186, 190},
			{96, 110, 110},
			{110, 114, 128},
			{260, 186, 168},
			{130, 192, 174},
			{130, 238, 178},
			{130, 156, 158},
			{70, 132, 160},
			{140, 180, 202},
			{60, 148, 142},
			{120, 190, 190},
			{160, 182, 162},
			{320, 180, 180},
			{180, 198, 242},
			{180, 232, 194},
			{180, 242, 194},
			{82, 128, 110},
			{122, 170, 152},
			{182, 250, 212},
			{212, 284, 202},
			{200, 220, 220}

	};
	private final int Overall[][] = {
			{45, 37},
			{36, 30},
			{29, 23},
			{22, 0}
	};
	private final int Stats[][] = {
			{15, 15},
			{14, 13},
			{12, 8},
			{7, 0}
	};
	private Map<Double, Double> PokemonLevel = new HashMap<Double, Double>(){
		{
			put(1.0, 0.094);
			put(1.5, 0.135137);
			put(2.0, 0.166398);
			put(2.5, 0.192651);
			put(3.0, 0.215732);
			put(3.5, 0.236573);
			put(4.0, 0.25572);
			put(4.5, 0.27353);
			put(5.0, 0.29025);
			put(5.5, 0.306057);
			put(6.0, 0.321088);
			put(6.5, 0.335445);
			put(7.0, 0.349213);
			put(7.5, 0.362458);
			put(8.0, 0.375236);
			put(8.5, 0.387592);
			put(9.0, 0.399567);
			put(9.5, 0.411194);
			put(10.0, 0.4225);
			put(10.5, 0.432926);
			put(11.0, 0.443108);
			put(11.5, 0.45306);
			put(12.0, 0.462798);
			put(12.5, 0.472336);
			put(13.0, 0.481685);
			put(13.5, 0.490856);
			put(14.0, 0.499858);
			put(14.5, 0.508702);
			put(15.0, 0.517394);
			put(15.5, 0.525942);
			put(16.0, 0.534354);
			put(16.5, 0.542636);
			put(17.0, 0.550793);
			put(17.5, 0.558831);
			put(18.0, 0.566755);
			put(18.5, 0.574569);
			put(19.0, 0.582279);
			put(19.5, 0.589888);
			put(20.0, 0.5974);
			put(20.5, 0.604819);
			put(21.0, 0.612157);
			put(21.5, 0.619404);
			put(22.0, 0.626567);
			put(22.5, 0.633649);
			put(23.0, 0.640653);
			put(23.5, 0.647581);
			put(24.0, 0.654436);
			put(24.5, 0.661219);
			put(25.0, 0.667934);
			put(25.5, 0.674582);
			put(26.0, 0.681165);
			put(26.5, 0.687685);
			put(27.0, 0.694144);
			put(27.5, 0.700543);
			put(28.0, 0.706884);
			put(28.5, 0.713169);
			put(29.0, 0.719399);
			put(29.5, 0.725576);
			put(30.0, 0.7317);
			put(30.5, 0.734741);
			put(31.0, 0.737769);
			put(31.5, 0.740786);
			put(32.0, 0.743789);
			put(32.5, 0.746781);
			put(33.0, 0.749761);
			put(33.5, 0.752729);
			put(34.0, 0.755686);
			put(34.5, 0.75863);
			put(35.0, 0.761564);
			put(35.5, 0.764486);
			put(36.0, 0.767397);
			put(36.5, 0.770297);
			put(37.0, 0.773186);
			put(37.5, 0.776065);
			put(38.0, 0.778933);
			put(38.5, 0.78179);
			put(39.0, 0.784637);
			put(39.5, 0.787474);
			put(40.0, 0.7903);
			put(40.5, 0.793116);

		}
	};
	
	public boolean calculate(int ID, int CP, int HP, int SD, boolean PU){
		result = "";
		stats = "";
		error = "";
		
		//calculate
		int level;
        if(SD <= 1000){
            level = (SD-200)/100+1;
        }else if(SD <= 2500){
            level = (SD-1000)/150+9;
        }else if(SD <= 5000){
            level = (SD-2500)/250+19;
        }else{
            level = (SD-5000)/500+29;
        }
		
        int StamIV, AtkIV, DefIV;
        int BStam = Pokemon[ID][0];
        int BAtk = Pokemon[ID][1];
        int BDef = Pokemon[ID][2];
        Map<Double, Double> IVS = new HashMap<Double, Double>();
        Map<Double, Double> XIV = new HashMap<Double, Double>();
        Map<Double, Double> NIV = new HashMap<Double, Double>();
        Map<Double, Integer> NOP = new HashMap<Double, Integer>();
        
        int TNOP = 0;
        double MaxIV = 0.0;
        double MinIV = 100.0;
        double IVSum = 0.0;
        
        for(double LV = level; LV < level+2; LV += PU? 0.5 : 1.0){
        	IVS.put(LV, 0.0);
        	XIV.put(LV, 0.0);
        	NIV.put(LV, 100.0);
        	NOP.put(LV, 0);
        	double PL = PokemonLevel.get(LV);
            for(StamIV = 0; StamIV < 16; StamIV++){
                int pHP = (int) Math.max((BStam + StamIV) * PL, 10);
                if(HP == pHP){
                    for(AtkIV = 0; AtkIV < 16; AtkIV++){
                        for(DefIV = 0; DefIV < 16; DefIV++){
                            int pCP = (int) Math.max((BAtk + AtkIV) * Math.pow(BStam + StamIV, 0.5) * Math.pow(BDef + DefIV, 0.5) * Math.pow(PL, 2) / 10, 10);
                            if(CP == pCP){
                                double IV = (StamIV + AtkIV + DefIV) * 100.0 / 45.0 ;
                                IVS.replace(LV, IVS.get(LV) + IV);
                                if(IV > XIV.get(LV)) XIV.replace(LV, IV);
                                if(IV < NIV.get(LV)) NIV.replace(LV, IV);
                                NOP.replace(LV, NOP.get(LV) + 1);
                                stats += String.format("\n\t%d\t%d\t%d\t%d\t%.1f%%", (int)LV, StamIV, AtkIV, DefIV, IV);
                            }
                        }
                    }
                }
            }
            TNOP += NOP.get(LV);
            if(MaxIV < XIV.get(LV)) MaxIV = XIV.get(LV);
            if(MinIV > NIV.get(LV)) MinIV = NIV.get(LV);
            IVSum += IVS.get(LV);
        }

        if(TNOP == 0){
        	error = "No matching! Check your CP and HP";
            return false;
        }else{
            result += String.format("\n\t\t%d\t%.1f\t%.1f\t%.1f\t", TNOP, MaxIV, IVSum / TNOP, MinIV);
            for(double LV = level; LV < level+2; LV += PU? 0.5 : 1.0){
            	if(NOP.get(LV) != 0){
            		result += String.format("\n\t%.1f\t%d\t%.1f\t%.1f\t%.1f\t", LV, NOP.get(LV), XIV.get(LV), IVS.get(LV) / NOP.get(LV), NIV.get(LV));
            	}
            }
        }
        
		return true;
	}
	
	public boolean calculateAdvance(int ID, int CP, int HP, int SD, boolean PU, int OVC, boolean Stam, boolean Atk, boolean Def, int SC){
		result = "";
		stats = "";
		error = "";
		
		//calculate
		int level;
        if(SD <= 1000){
            level = (SD-200)/100+1;
        }else if(SD <= 2500){
            level = (SD-1000)/150+9;
        }else if(SD <= 5000){
            level = (SD-2500)/250+19;
        }else{
            level = (SD-5000)/500+29;
        }
		
        int StamIV, AtkIV, DefIV;
        int BStam = Pokemon[ID][0];
        int BAtk = Pokemon[ID][1];
        int BDef = Pokemon[ID][2];
        Map<Double, Double> IVS = new HashMap<Double, Double>();
        Map<Double, Double> XIV = new HashMap<Double, Double>();
        Map<Double, Double> NIV = new HashMap<Double, Double>();
        Map<Double, Integer> NOP = new HashMap<Double, Integer>();
        
        //list<vector<int>> PL1, PL2;
        //Vector<Vector<Integer>> v = new Vector<Vector<Integer>>();
        int TNOP = 0;
        double MaxIV = 0.0;
        double MinIV = 100.0;
        double IVSum = 0.0;
        
        for(double LV = level; LV < level+2; LV += PU? 0.5 : 1.0){
        	IVS.put(LV, 0.0);
        	XIV.put(LV, 0.0);
        	NIV.put(LV, 100.0);
        	NOP.put(LV, 0);
        	//Vector<>
        	double PL = PokemonLevel.get(LV);
            for(StamIV = 0; StamIV < 16; StamIV++){
                int pHP = (int) Math.max((BStam + StamIV) * PL, 10);
                if(HP == pHP){
                    for(AtkIV = 0; AtkIV < 16; AtkIV++){
                        for(DefIV = 0; DefIV < 16; DefIV++){
                            int pCP = (int) Math.max((BAtk + AtkIV) * Math.pow(BStam + StamIV, 0.5) * Math.pow(BDef + DefIV, 0.5) * Math.pow(PL, 2) / 10, 10);
                            int SAD = StamIV + AtkIV + DefIV;
                            if(CP == pCP && SAD <= Overall[OVC][0] && SAD >= Overall[OVC][1] &&
                            (((Stam && StamIV >= AtkIV && StamIV >= DefIV && StamIV <= Stats[SC][0] && StamIV >= Stats[SC][1]) ||
                            (!Stam && (StamIV < AtkIV || StamIV < DefIV))) &&
                            ((Atk && AtkIV >= StamIV && AtkIV >= DefIV && AtkIV <= Stats[SC][0] && AtkIV >= Stats[SC][1]) ||
                            (!Atk && (AtkIV < StamIV || AtkIV < DefIV))) &&
                            ((Def && DefIV >= StamIV && DefIV >= StamIV && DefIV <= Stats[SC][0] && DefIV >= Stats[SC][1]) ||
                            (!Def && (DefIV < StamIV || DefIV < AtkIV))))){
                                //PL1.push_back(vector<int>{StamIV, AtkIV, DefIV});
                                double IV = (StamIV + AtkIV + DefIV) * 100.0 / 45.0 ;
                                IVS.replace(LV, IVS.get(LV) + IV);
                                if(IV > XIV.get(LV)) XIV.replace(LV, IV);
                                if(IV < NIV.get(LV)) NIV.replace(LV, IV);
                                NOP.replace(LV, NOP.get(LV) + 1);
                                stats += String.format("\n\t%d\t%d\t%d\t%d\t%.1f%%", (int)LV, StamIV, AtkIV, DefIV, IV);
                            }
                        }
                    }
                }
            }
            TNOP += NOP.get(LV);
            if(MaxIV < XIV.get(LV)) MaxIV = XIV.get(LV);
            if(MinIV > NIV.get(LV)) MinIV = NIV.get(LV);
            IVSum += IVS.get(LV);
        }

        if(TNOP == 0){
        	error = "No matching! Check your CP and HP";
            return false;
        }else{
            result += String.format("\n\t\t%d\t%.1f\t%.1f\t%.1f\t", TNOP, MaxIV, IVSum / TNOP, MinIV);
            for(double LV = level; LV < level+2; LV += PU? 0.5 : 1.0){
            	if(NOP.get(LV) != 0){
            		result += String.format("\n\t%.1f\t%d\t%.1f\t%.1f\t%.1f\t", LV, NOP.get(LV), XIV.get(LV), IVS.get(LV) / NOP.get(LV), NIV.get(LV));
            	}
            }
        }
        
		return true;
	}
	
	public String getResult(){
		
		return result;
	}
	public String getStats(){
		
		return stats;
	}
	public String getError(){
		
		return error;
	}
}
