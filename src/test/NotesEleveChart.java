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
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
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
		
		/** On lance notre graphique**/
		final NotesEleveChart notesEleve = new NotesEleveChart("Notes eleve test");
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
            "Notes eleve test",        // chart title
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
	
		/** On en selectionne un aleatoire*/
    	Random random = new Random();
    	//System.out.println(promotion.getEleves().size());
		int randomInt = random.nextInt(promotion.getEleves().size());
		ArrayList<Eleve> eleves = promotion.getEleves();
		Eleve randomEleve = eleves.get(randomInt);
		
		/** On attribue des notes à tous les eleves*/
		remplirEvalEleves();
		System.out.println(eleves.get(randomInt));
		
        final String series1 = randomEleve.getNom() + " " + randomEleve.getPrenom();
        final String series2 = "Moyenne " + promotion.getNom();
        final String series3 = "Mediane "+ promotion.getNom();

        final String matiere1 = "Mathematiques";
        final String matiere2 = "Physique";
        final String matiere3 = "Anglais";
        final String matiere4 = "Finance";
        final String matiere5 = "Informatique";
        final String matiere6 = "Algorithmie";
        final String matiere7 = "Communication";
        final String matiere8 = "LV2";
        final String matiere9 = "Marketing";
        final String matiere10 = "Management";

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        /** Les notes de l'eleve*/
        for (Evaluation evaluation : randomEleve.getEvaluations()) {
        	dataset.addValue(evaluation.getNote(), series1, evaluation.getMatiere());
		}
        
        /** les moyennes de la promo */
        dataset.addValue(1.0, series2, matiere1);
        dataset.addValue(4.0, series2, matiere2);
        dataset.addValue(3.0, series2, matiere3);
        dataset.addValue(5.0, series2, matiere4);
        dataset.addValue(5.0, series2, matiere5);
        dataset.addValue(7.0, series2, matiere6);
        dataset.addValue(7.0, series2, matiere7);
        dataset.addValue(8.0, series2, matiere8);
        dataset.addValue(8.0, series2, matiere9);
        dataset.addValue(20.0, series2, matiere10);
        
        dataset.addValue(1.0, series3, matiere1);
        dataset.addValue(4.0, series3, matiere2);
        dataset.addValue(3.0, series3, matiere3);
        dataset.addValue(5.0, series3, matiere4);
        dataset.addValue(5.0, series3, matiere5);
        dataset.addValue(7.0, series3, matiere6);
        dataset.addValue(7.0, series3, matiere7);
        dataset.addValue(8.0, series3, matiere8);
        dataset.addValue(8.0, series3, matiere9);
        dataset.addValue(20.0, series3, matiere10);


        return dataset;

    }
    
    /**
     * Permet de remplir les evaluations des eleves avec des notes aleatoires
     * a mettre dans promotion
     */
    public static void remplirEvalEleves() {
    	for (Eleve eleve : eleves) {
    		for (Professeur prof : profs) {
    			eleve.setEvaluation(new Evaluation("Mathematiques", eleve.randomMark() , eleve, prof));
    			eleve.setEvaluation(new Evaluation("Physique", eleve.randomMark(), eleve, prof));
    			eleve.setEvaluation(new Evaluation("Anglais", eleve.randomMark(), eleve, prof));
    			eleve.setEvaluation(new Evaluation("Finance", eleve.randomMark(), eleve, prof));
    			eleve.setEvaluation(new Evaluation("Informatique", eleve.randomMark(), eleve, prof));
    			eleve.setEvaluation(new Evaluation("Algorithmie", eleve.randomMark(), eleve, prof));
    			eleve.setEvaluation(new Evaluation("Communication", eleve.randomMark(), eleve, prof));
    			eleve.setEvaluation(new Evaluation("LV2", eleve.randomMark(), eleve, prof));
    			eleve.setEvaluation(new Evaluation("Marketing", eleve.randomMark(), eleve, prof));
    			eleve.setEvaluation(new Evaluation("Management", eleve.randomMark(), eleve, prof));
    		}
		}
    }

}
