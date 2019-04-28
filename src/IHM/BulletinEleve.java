package IHM;
import java.awt.Color;

import javax.swing.JFrame;

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
import notesElevesProfesseurs.Eleve;
import notesElevesProfesseurs.Evaluation;
import notesElevesProfesseurs.Promotion;


public class BulletinEleve extends JFrame {

	private static final long serialVersionUID = 1L;
//	private Eleve bulletinEleve = null;
//	private Promotion promotion = null;

	public BulletinEleve(final String title, Eleve _bulletinEleve, Promotion _promotion) {
        super(title);      
       
        Eleve bulletinEleve = _bulletinEleve;
    	Promotion promotion = _promotion;
        final CategoryDataset dataset1 = createDataset1(bulletinEleve, promotion);
//        this.promotion = promotion;
//        this.bulletinEleve = bulletinEleve;

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

    private CategoryDataset createDataset1(Eleve bulletinEleve, Promotion promotion) {
	
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

			System.out.println("---- Bulletin de: ----");
			System.out.println(bulletinEleve);
			
	        final String series1 = bulletinEleve.getNom() + " " + bulletinEleve.getPrenom();
	        final String series2 = "Moyenne " + promotion.getNom();
	        final String series3 = "Mediane "+ promotion.getNom();
	        
	        System.out.println(bulletinEleve);


	        /** Les notes de l'eleve*/
	        for (Evaluation evaluation : bulletinEleve.getEvaluations()) {
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
	        System.out.print("Moyenne generale de " + bulletinEleve.getNom() + ": ");
	        System.out.println(bulletinEleve.moyenne());
	        
	        /** Mediane de l'eleve*/
	        System.out.print("Mediane generale de " + bulletinEleve.getNom() +  ": ");
	        System.out.println(bulletinEleve.mediane());
	        
	        System.out.println("");
	        
	        /**Moyenne de la promotion*/
	        System.out.print("Moyenne generale de la promotion: ");
	        System.out.println(promotion.moyenne());
	        
	        /**Mediane de la promotion*/
	        System.out.print("Mediane generale de la promotion: ");
	        System.out.println(promotion.mediane());
		
        
        return dataset;
    }
}
