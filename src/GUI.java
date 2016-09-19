import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame{
	private JComboBox<String> Pokemon_ID;
	private JTextField Pokemon_CP;
	private JTextField Pokemon_HP;
	private JComboBox<Integer> Pokemon_SD;
	private JCheckBox Pokemon_PU;
	private JComboBox<String> Pokemon_Overall;
	private JCheckBox Pokemon_Stam;
	private JCheckBox Pokemon_Atk;
	private JCheckBox Pokemon_Def;
	private JComboBox<String> Pokemon_Stats;
	private JButton Submit_button;
	private JTextArea Stats_table;
	private JTextArea Result_table;
	private Calculator Result;
	
	private final String[] Pokemon_name = {"bulbasaur", "ivysaur", "venusaur", "charmander", "charmeleon", "charizard", "squirtle", "wartortle", "blastoise", "caterpie", "metapod", "butterfree", "weedle", "kakuna", "beedrill", "pidgey", "pidgeotto", "pidgeot", "rattata", "raticate", "spearow", "fearow", "ekans", "arbok", "pikachu", "raichu", "sandshrew", "sandslash", "nidoran", "nidorina", "nidoqueen", "nidoran", "nidorino", "nidoking", "clefairy", "clefable", "vulpix", "ninetales", "jigglypuff", "wigglytuff", "zubat", "golbat", "oddish", "gloom", "vileplume", "paras", "parasect", "venonat", "venomoth", "diglett", "dugtrio", "meowth", "persian", "psyduck", "golduck", "mankey", "primeape", "growlithe", "arcanine", "poliwag", "poliwhirl", "poliwrath", "abra", "kadabra", "alakazam", "machop", "machoke", "machamp", "bellsprout", "weepinbell", "victreebel", "tentacool", "tentacruel", "geodude", "graveler", "golem", "ponyta", "rapidash", "slowpoke", "slowbro", "magnemite", "magneton", "farfetchd", "doduo", "dodrio", "seel", "dewgong", "grimer", "muk", "shellder", "cloyster", "gastly", "haunter", "gengar", "onix", "drowzee", "hypno", "krabby", "kingler", "voltorb", "electrode", "exeggcute", "exeggutor", "cubone", "marowak", "hitmonlee", "hitmonchan", "lickitung", "koffing", "weezing", "rhyhorn", "rhydon", "chansey", "tangela", "kangaskhan", "horsea", "seadra", "goldeen", "seaking", "staryu", "starmie", "mr_mime", "scyther", "jynx", "electabuzz", "magmar", "pinsir", "tauros", "magikarp", "gyarados", "lapras", "ditto", "eevee", "vaporeon", "jolteon", "flareon", "porygon", "omanyte", "omastar", "kabuto", "kabutops", "aerodactyl", "snorlax", "articuno", "zapdos", "moltres", "dratini", "dragonair", "dragonite", "mewtwo", "mew"};
	private final Integer[] Stardust = {200, 400, 800, 1000, 1300, 1600, 1900, 2200, 2500, 3000, 3500, 4000, 4500, 5000, 6000, 7000, 8000, 9000, 10000};
	private final String[] Overall_comment = {"S", "A", "B", "C"};
	private final String[] Stats_comment = {"S", "A", "B", "C"};
	private final String Stats_title = "\tLevel\tStamina\tAttack\tDefense\tIV\t";
	private final String Result_title = "\tLV\tPos\tMaxIV\tAvgIV\tMinIV\t";
	
	private int ID, CP, HP, SD, OVC, SC;
	private boolean PU, Stam, Atk, Def;
	
	public GUI(){
		super("Pokemon IV Calaulator for Pokemon Go");
		setLayout(new FlowLayout());
		
		Pokemon_ID = new JComboBox<String>(Pokemon_name);
		add(Pokemon_ID);
		Pokemon_CP = new JTextField("10", 6);
		add(Pokemon_CP);
		Pokemon_HP = new JTextField("10", 6);
		add(Pokemon_HP);
		Pokemon_SD = new JComboBox<Integer>(Stardust);
		add(Pokemon_SD);
		Pokemon_PU = new JCheckBox("Power Up");
		add(Pokemon_PU);
		Pokemon_Overall = new JComboBox<String>(Overall_comment);
		add(Pokemon_Overall);
		Pokemon_Stam = new JCheckBox("HP");
		add(Pokemon_Stam);
		Pokemon_Atk = new JCheckBox("Attack");
		add(Pokemon_Atk);
		Pokemon_Def = new JCheckBox("Defense");
		add(Pokemon_Def);
		Pokemon_Stats = new JComboBox<String>(Stats_comment);
		add(Pokemon_Stats);
		Submit_button = new JButton("submit");
		add(Submit_button);
		Result = new Calculator();
		
		//Poss_table.setFont(new Font("", Font.PLAIN, 14));
		
		Result_table = new JTextArea(Result_title);
		Result_table.setEditable(false);
		add(Result_table);
		
		Stats_table = new JTextArea(Stats_title);
		Stats_table.setEditable(false);
		add(Stats_table);
		
		thehandler handler = new thehandler();
		Submit_button.addActionListener(handler);
		
	}
	private class thehandler implements ActionListener{
		public void actionPerformed(ActionEvent event){
			ID = Pokemon_ID.getSelectedIndex();
			CP = Integer.parseInt(Pokemon_CP.getText());
			HP = Integer.parseInt(Pokemon_HP.getText());
			SD = (Integer) Pokemon_SD.getSelectedItem();
			PU = Pokemon_PU.isSelected();
			OVC = Pokemon_Overall.getSelectedIndex();
			Stam = Pokemon_Stam.isSelected();
			Atk = Pokemon_Atk.isSelected();
			Def = Pokemon_Def.isSelected();
			SC = Pokemon_Stats.getSelectedIndex();
			
			if(Stam || Atk || Def){
				if(Result.calculateAdvance(ID, CP, HP, SD, PU, OVC, Stam, Atk, Def, SC)){
					Result_table.setText(Result_title + Result.getResult());
					Stats_table.setText(Stats_title + Result.getStats());
				}else{
					Result_table.setText(Result_title);
					Stats_table.setText(Stats_title);
					
					JOptionPane.showMessageDialog(null, Result.getError());
				}
			}else{
				if(Result.calculate(ID, CP, HP, SD, PU)){
					Result_table.setText(Result_title + Result.getResult());
					Stats_table.setText(Stats_title + Result.getStats());
				}else{
					Result_table.setText(Result_title);
					Stats_table.setText(Stats_title);
					
					JOptionPane.showMessageDialog(null, Result.getError());
				}
			}
			
			
		}
	}
	
}