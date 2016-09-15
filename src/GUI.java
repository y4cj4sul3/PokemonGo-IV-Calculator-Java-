import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame{
	private JComboBox Pokemon_ID;
	private JTextField Pokemon_CP;
	private JTextField Pokemon_HP;
	private JComboBox Pokemon_SD;
	private JCheckBox Pokemon_PU;
	private JCheckBox Pokemon_Stam;
	private JCheckBox Pokemon_Atk;
	private JCheckBox Pokemon_Def;
	private JButton Submit_button;
	private JTextArea Stats_table;
	private JTextArea Result_table;
	private Calculator Result;
	
	private static String[] Pokemon_name = {"bulbasaur", "ivysaur", "venusaur", "charmander", "charmeleon", "charizard", "squirtle", "wartortle", "blastoise", "caterpie", "metapod", "butterfree", "weedle", "kakuna", "beedrill", "pidgey", "pidgeotto", "pidgeot", "rattata", "raticate", "spearow", "fearow", "ekans", "arbok", "pikachu", "raichu", "sandshrew", "sandslash", "nidoran", "nidorina", "nidoqueen", "nidoran", "nidorino", "nidoking", "clefairy", "clefable", "vulpix", "ninetales", "jigglypuff", "wigglytuff", "zubat", "golbat", "oddish", "gloom", "vileplume", "paras", "parasect", "venonat", "venomoth", "diglett", "dugtrio", "meowth", "persian", "psyduck", "golduck", "mankey", "primeape", "growlithe", "arcanine", "poliwag", "poliwhirl", "poliwrath", "abra", "kadabra", "alakazam", "machop", "machoke", "machamp", "bellsprout", "weepinbell", "victreebel", "tentacool", "tentacruel", "geodude", "graveler", "golem", "ponyta", "rapidash", "slowpoke", "slowbro", "magnemite", "magneton", "farfetchd", "doduo", "dodrio", "seel", "dewgong", "grimer", "muk", "shellder", "cloyster", "gastly", "haunter", "gengar", "onix", "drowzee", "hypno", "krabby", "kingler", "voltorb", "electrode", "exeggcute", "exeggutor", "cubone", "marowak", "hitmonlee", "hitmonchan", "lickitung", "koffing", "weezing", "rhyhorn", "rhydon", "chansey", "tangela", "kangaskhan", "horsea", "seadra", "goldeen", "seaking", "staryu", "starmie", "mr_mime", "scyther", "jynx", "electabuzz", "magmar", "pinsir", "tauros", "magikarp", "gyarados", "lapras", "ditto", "eevee", "vaporeon", "jolteon", "flareon", "porygon", "omanyte", "omastar", "kabuto", "kabutops", "aerodactyl", "snorlax", "articuno", "zapdos", "moltres", "dratini", "dragonair", "dragonite", "mewtwo", "mew"};
	private static String[] Stardust = {"200", "400", "800", "1000", "1300", "1600", "1900", "2200", "2500", "3000", "3500", "4000", "4500", "5000", "6000", "7000", "8000", "9000", "10000"};
	private final String Stats_title = "\tLevel\tStamina\tAttack\tDefense\tIV\t";
	private final String Result_title = "\tLV\tPos\tMaxIV\tAvgIV\tMinIV\t";
	
	private int ID, CP, HP, SD;
	
	public GUI(){
		super("Pokemon IV Calaulator for Pokemon Go");
		setLayout(new FlowLayout());
		
		Pokemon_ID = new JComboBox(Pokemon_name);
		add(Pokemon_ID);
		Pokemon_CP = new JTextField("10", 6);
		add(Pokemon_CP);
		Pokemon_HP = new JTextField("10", 6);
		add(Pokemon_HP);
		Pokemon_SD = new JComboBox(Stardust);
		add(Pokemon_SD);
		Pokemon_PU = new JCheckBox("Power Up");
		add(Pokemon_PU);
		Pokemon_Stam = new JCheckBox("HP");
		add(Pokemon_Stam);
		Pokemon_Atk = new JCheckBox("Attack");
		add(Pokemon_Atk);
		Pokemon_Def = new JCheckBox("Defense");
		add(Pokemon_Def);
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
			SD = Integer.parseInt((String) Pokemon_SD.getSelectedItem());
			
			if(Result.calculate(ID, CP, HP, SD, Pokemon_PU.isSelected(), Pokemon_Stam.isSelected(), Pokemon_Atk.isSelected(), Pokemon_Def.isSelected())){
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