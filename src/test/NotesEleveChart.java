package test;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import notesElevesProfesseurs.Eleve;
import notesElevesProfesseurs.Evaluation;
import notesElevesProfesseurs.Professeur;
import notesElevesProfesseurs.Promotion;
import readCSV.ReadCSV;


public class NotesEleveChart extends ApplicationFrame {

	private static final long serialVersionUID = 1L;
	private static Promotion promotion = new Promotion("2021");
	private static List<Eleve> eleves = new ArrayList<>();
	private static List<Professeur> profs = new ArrayList<>();

    public static void main(final String[] args) {
		/** On cree les eleves*/
    	eleves = ReadCSV.readElevesFromCSV();
		profs = ReadCSV.readProfesseursFromCSV();
		
		/** On donne la promotion sur laquelle les profs interviennent */
		for (Professeur prof : profs) {
			prof.addPromotionToProf(promotion);
			//System.out.println(prof.getNom() + " " +prof.getPromotionsOfProf());
		}
		
		//System.out.println(promotion.getProfesseurs());
		
		/** On lance notre graphique**/
		final NotesEleveChart notesEleve = new NotesEleveChart("Bulletin de notes");
		notesEleve.pack();
        RefineryUtilities.centerFrameOnScreen(notesEleve);
        notesEleve.setVisible(true);

    }

	public NotesEleveChart(final String title) {
        super(title);
        
        if(Promotion.getPromotions().isEmpty())
        	promotion = new Promotion("2021");
        else
        	promotion = Promotion.getPromotions().get(0);
        
        final CategoryDataset dataset1 = createDataset1();

        // create the chart...
        final JFreeChart chart = ChartFactory.createBarChart(
            "Bulletin de notes",        // chart title
            "Matiere",               // domain axis label
            "Note",                  // range axis label
            dataset1,                 // data
            PlotOrientation.VERTICAL,
            true,                     // include legend
            true,                     // tooltips?
            false                     // URL generator?  Not required...
        );

        chart.setBackgroundPaint(Color.white);

        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(0xEE, 0xEE, 0xFF));
        plot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);

        final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);

        final LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();
        plot.setRenderer(1, renderer2);
        plot.setDatasetRenderingOrder(DatasetRenderingOrder.REVERSE);

        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(900, 400));
        setContentPane(chartPanel);
    }

    private CategoryDataset createDataset1() {
	
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		/** On en selectionne un aleatoire*/
    	Random random = new Random();
    	//System.out.println(promotion.getEleves().size());
		int randomInt = random.nextInt(promotion.getEleves().size());
		ArrayList<Eleve> eleves = promotion.getEleves();
		Eleve randomEleve = eleves.get(randomInt);
		
		/** On attribue des notes à tous les eleves et si c bon on rempli les graphiques*/
		if(promotion.remplirEvalEleves()) {
			System.out.println("---- Bulletin de: ----");
			System.out.println(randomEleve);
			
	        final String series1 = randomEleve.getNom() + " " + randomEleve.getPrenom();
	        final String series2 = "Moyenne " + promotion.getNom();
	        final String series3 = "Mediane "+ promotion.getNom();
	        
//	        final ArrayList<String> matieres = new ArrayList<String>();
//	        for (Evaluation evaluation : randomEleve.getEvaluations()) {
//	        	matieres.add(evaluation.getMatiere());
//			}
//	        
	        System.out.println(eleves);


	        /** Les notes de l'eleve*/
	        for (Evaluation evaluation : randomEleve.getEvaluations()) {
	        	String matiere = evaluation.getMatiere();
	        	
	        	dataset.addValue(evaluation.getNote(), series1, matiere);
	        	
	        	/** Moyenne de la promo pour la matiere */
	        	dataset.addValue(promotion.moyenneParMatiere(matiere), series2, matiere);
	        	//System.out.println("moyenne promo pour: " + matiere + " : "+ promotion.moyenneParMatiere(matiere));
	            
	            /** Medianne de la promo pour la matiere */
	            dataset.addValue(promotion.medianeParMatiere(matiere), series3, matiere);
	            //System.out.println("mediane promo pour:" + matiere + " : "  + promotion.medianeParMatiere(matiere));
			}
	        
	        /** Moyenne de l'eleve*/
	        System.out.print("Moyenne generale de " + randomEleve.getNom() + ": ");
	        System.out.println(randomEleve.moyenne());
	        
	        /** Mediane de l'eleve*/
	        System.out.print("Mediane generale de " + randomEleve.getNom() +  ": ");
	        System.out.println(randomEleve.mediane());
	        
	        System.out.println("");
	        
	        /**Moyenne de la promotion*/
	        System.out.print("Moyenne generale de la promotion: ");
	        System.out.println(promotion.moyenne());
	        
	        /**Mediane de la promotion*/
	        System.out.print("Mediane generale de la promotion: ");
	        System.out.println(promotion.mediane());
		}else {
			System.out.println("Les notes n'ont pas correctement étés ajoutés.. "
					+ "par conséquent bulletin vide");
		}
		
        
        return dataset;
    }
    
    /**
     * Permet de remplir les evaluations des eleves avec des notes aleatoires
     * a mettre dans promotion
     */
    public static void remplirEvalEleves() {
    	for (Eleve eleve : eleves) {
			eleve.setEvaluation(new Evaluation("Mathematiques", eleve.randomMark() , eleve, profs.get(0)));
			eleve.setEvaluation(new Evaluation("Physique", eleve.randomMark(), eleve, profs.get(1)));
			eleve.setEvaluation(new Evaluation("Anglais", eleve.randomMark(), eleve, profs.get(2)));
			eleve.setEvaluation(new Evaluation("Finance", eleve.randomMark(), eleve, profs.get(3)));
			eleve.setEvaluation(new Evaluation("Informatique", eleve.randomMark(), eleve, profs.get(4)));
			eleve.setEvaluation(new Evaluation("Algorithmie", eleve.randomMark(), eleve, profs.get(5)));
			eleve.setEvaluation(new Evaluation("Communication", eleve.randomMark(), eleve, profs.get(6)));
			eleve.setEvaluation(new Evaluation("LV2", eleve.randomMark(), eleve, profs.get(7)));
			eleve.setEvaluation(new Evaluation("Marketing", eleve.randomMark(), eleve, profs.get(8)));
			eleve.setEvaluation(new Evaluation("Management", eleve.randomMark(), eleve, profs.get(9)));
    		
		}
    }

}
