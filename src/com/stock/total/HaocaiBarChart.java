/*
 * TianFang science corporation (c)2012 all rights reserved.
 * Description:  create ShoufeiBarChart .
 * Update:
 * Date         Name                  Reason
 * ============ ===================== ==========
 * 2012-12-21   Li.Hai-Han(**)        Create
 */
package com.stock.total;

import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategorySeriesLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;

/**
 * ShoufeiBarChart.
 * 
 * @author Li.Hai-Han(**)
 */
public class HaocaiBarChart extends ApplicationFrame
{
	private static final long serialVersionUID = 1L;

	public HaocaiBarChart(String s ,String path ,List<?> l ) throws UnsupportedEncodingException {
		super(s);
		createDemoPanel(path ,l );
		//jpanel.setPreferredSize(new Dimension(800, 470));
		//setContentPane(jpanel);
	}

	private static CategoryDataset createDataset(List<?> list) {
		DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
		String s =  "接线子 ";
		String s1 = "RJ11";
		String s2 = "RJ45";
		String s3 = "模块";
		String s4 = "面板";
		String s5 = "网线";
	
		try {
			for(int i=0 ; i < list.size() ; i++) {
				TotalForm t = (TotalForm) list.get(i);
				defaultcategorydataset.addValue(Double.parseDouble(t.getJiexianziNum()), s  , t.getXiaoqu());
				defaultcategorydataset.addValue(Double.parseDouble(t.getRj11Num())     , s1 , t.getXiaoqu());
				defaultcategorydataset.addValue(Double.parseDouble(t.getRj45Num())     , s2 , t.getXiaoqu());
				defaultcategorydataset.addValue(Double.parseDouble(t.getMokuaiNum())   , s3 , t.getXiaoqu());
				defaultcategorydataset.addValue(Double.parseDouble(t.getMianbanNum())  , s4 , t.getXiaoqu());
				defaultcategorydataset.addValue(Double.parseDouble(t.getWangxianNum()) , s5 , t.getXiaoqu());
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return defaultcategorydataset;
	}

	private static JFreeChart createChart(CategoryDataset categorydataset) throws UnsupportedEncodingException {
		JFreeChart jfreechart = ChartFactory.createBarChart("耗材统计", null, "数量" , categorydataset, PlotOrientation.VERTICAL, true, true, false);
		jfreechart.getTitle().setFont(new Font("黑体",Font.PLAIN,20));//设置标题字体
		jfreechart.getLegend().setItemFont(new Font("黑体", Font.PLAIN, 15));//横轴框里的标题字体
		jfreechart.getLegend().setPosition(RectangleEdge.LEFT);
		jfreechart.getLegend().setMargin(RectangleInsets.ZERO_INSETS);
		//获取高级属性设置
		CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
		
		//设置网格竖线
		//categoryplot.setDomainGridlinePaint(Color.blue);
		//categoryplot.setDomainGridlinesVisible(true);
		
		categoryplot.setRangeAxisLocation(AxisLocation.TOP_OR_LEFT);
		//设置网格横线
		categoryplot.setRangeGridlinePaint(Color.blue);
		categoryplot.setRangeGridlinesVisible(true);
		
		//设置背景颜色
		categoryplot.setBackgroundPaint(Color.LIGHT_GRAY);
		categoryplot.setOutlineVisible(true);

		//柱形边框颜色
		categoryplot.setOutlinePaint(Color.magenta);
		
		//纵轴字体
		categoryplot.getRangeAxis().setLabelFont(new Font("黑体", Font.PLAIN, 15));
		//横轴列表字体
		categoryplot.getDomainAxis().setTickLabelFont(new Font("黑体", Font.PLAIN, 15));
		//横轴小标题字体
		categoryplot.getDomainAxis().setLabelFont(new Font("黑体", Font.PLAIN, 12));
		
		BarRenderer3D renderer3d  = new BarRenderer3D();
		//场景边框颜色
		renderer3d.setBaseOutlinePaint(Color.ORANGE);
		renderer3d.setDrawBarOutline(true);
		
		//设置墙体颜色
		renderer3d.setWallPaint(Color.gray);
		renderer3d.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer3d.setBaseItemLabelsVisible(true);
		renderer3d.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12,TextAnchor.CENTER_LEFT));
		renderer3d.setItemLabelAnchorOffset(20);
		categoryplot.setRenderer(renderer3d);
		
		CategoryAxis domainAxis = categoryplot.getDomainAxis();
		//domainAxis.setUpperMargin(0.2);
		domainAxis.setLowerMargin(0.001);
		domainAxis.setTickMarksVisible(true);
		domainAxis.setTickMarkOutsideLength(100);
		domainAxis.setTickMarkInsideLength(100);
		domainAxis.setTickMarkPaint(Color.red);
		//domainAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
		
		NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
		numberaxis.setUpperMargin(0.2);  
		numberaxis.setLowerMargin(0.2);  
	    numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		
		BarRenderer barrenderer = (BarRenderer)categoryplot.getRenderer();
		barrenderer.setDrawBarOutline(true);
		barrenderer.setMaximumBarWidth(0.100D);
		barrenderer.setMinimumBarLength(1);
		barrenderer.setLegendItemLabelGenerator(new StandardCategorySeriesLabelGenerator("{0}"));
		return jfreechart;
	}

	public static JPanel createDemoPanel(String path ,List<?> l) throws UnsupportedEncodingException {
		JFreeChart jfreechart = createChart(createDataset(l));
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			if(l.size() < 2){
				ChartUtilities.writeChartAsJPEG(fileOutputStream , jfreechart , 600 , 400);
			}else{
				ChartUtilities.writeChartAsJPEG(fileOutputStream , jfreechart , l.size() * 200 , 400);
			}
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ChartPanel(jfreechart);
	}
}
