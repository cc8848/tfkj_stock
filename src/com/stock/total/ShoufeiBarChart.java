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
import java.awt.Paint;
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
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.SubCategoryAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategorySeriesLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.data.KeyToGroupMap;
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
public class ShoufeiBarChart extends ApplicationFrame {
	private static final long serialVersionUID = 1L;

	public ShoufeiBarChart(String s ,String path ,List<?> l ) throws UnsupportedEncodingException {
		super(s);
		createDemoPanel(path ,l );
		//jpanel.setPreferredSize(new Dimension(800, 470));
		//setContentPane(jpanel);
	}

	private static CategoryDataset createDataset(List<?> list) {
		DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
		String s =  "已安装总收费";
		String s1 = "已维修总收费";
		String s2 = "已续费总收费";
		String s3 = "已退订总退费";
		try {
			for(int i = 0 ; i < list.size() ; i ++) {
				TotalForm t = (TotalForm) list.get(i);
				defaultcategorydataset.addValue(Double.parseDouble(t.getAnzhuangNum()) , s  , t.getXiaoqu());
				defaultcategorydataset.addValue(Double.parseDouble(t.getWeixiuNum())   , s1 , t.getXiaoqu());
				defaultcategorydataset.addValue(Double.parseDouble(t.getXufeiNum())    , s2 , t.getXiaoqu());
				defaultcategorydataset.addValue(t.getTuidingNum().equals("0")?0:Double.parseDouble("-"+t.getTuidingNum())  , s3 , t.getXiaoqu());
				//defaultcategorydataset.addValue(-1000000D   , s3 , t.getXiaoqu());
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return defaultcategorydataset;
	}

	private static JFreeChart createChart(CategoryDataset categorydataset) throws UnsupportedEncodingException {
		JFreeChart jfreechart = ChartFactory.createBarChart("收费统计", null, "金额" , categorydataset, PlotOrientation.VERTICAL, true, true, false);
		jfreechart.getTitle().setFont(new Font("黑体",Font.PLAIN,20));//设置标题字体
		jfreechart.getLegend().setItemFont(new Font("黑体", Font.PLAIN, 15));//横轴框里的标题字体
		jfreechart.getLegend().setPosition(RectangleEdge.LEFT);
		jfreechart.getLegend().setMargin(RectangleInsets.ZERO_INSETS);
		CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();	//获取高级属性设置
		//categoryplot.setDomainGridlinePaint(Color.blue);//设置网格竖线
		categoryplot.setDomainGridlinesVisible(true);
		categoryplot.setRangeAxisLocation(AxisLocation.TOP_OR_LEFT);
		categoryplot.setRangeGridlinePaint(Color.blue);//设置网格横线
		categoryplot.setRangeGridlinesVisible(true);
		categoryplot.setBackgroundPaint(Color.LIGHT_GRAY);//设置背景颜色
		categoryplot.setOutlineVisible(false);
		categoryplot.setDomainGridlinesVisible(true);
		categoryplot.setOutlinePaint(Color.magenta);	//柱形边框颜色
		categoryplot.getRangeAxis().setLabelFont(new Font("黑体", Font.PLAIN, 15));//纵轴字体
		categoryplot.getDomainAxis().setTickLabelFont(new Font("黑体", Font.PLAIN, 15));//横轴列表字体
		categoryplot.getDomainAxis().setLabelFont(new Font("黑体", Font.PLAIN, 12));//横轴小标题字体
		
		//横轴字体倾斜度
		//categoryplot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(0.39269908169872414D));
		//柱子宽度。全局
		categoryplot.getDomainAxis().setCategoryMargin(0.3D);	
		
		BarRenderer3D renderer3d  = new BarRenderer3D();
		renderer3d.setBaseOutlinePaint(Color.ORANGE);	//场景边框颜色
		renderer3d.setWallPaint(Color.gray);//设置墙体颜色
		renderer3d.setItemMargin(0.30000000000000000D);//柱子宽度局部
		renderer3d.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer3d.setBaseItemLabelsVisible(true);
		//负值显示
		renderer3d.setNegativeItemLabelPositionFallback(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_LEFT, TextAnchor.TOP_LEFT, 0.00D));
		//数值显示
		renderer3d.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_LEFT, TextAnchor.TOP_LEFT, 0.00D));
		renderer3d.setItemLabelAnchorOffset(30);
		renderer3d.setDrawBarOutline(true);	//设置标志，控制是否发送给注册的监听器。
		categoryplot.setRenderer(renderer3d);
		
		/*
		 * 轴的数值数据显示。
		 */
		NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
		numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		numberaxis.setLowerMargin(0.14999999999999999D);
		numberaxis.setUpperMargin(0.14999999999999999D);
		
		/*
		 * 轴显示。
		 */
		CategoryAxis domainAxis = categoryplot.getDomainAxis();
		domainAxis.setUpperMargin(0.01);
		//集的下缘为轴,越小离Y轴越近
		domainAxis.setLowerMargin(0.005);
		//套外的长度刻度标记
		domainAxis.setTickMarkOutsideLength(1);
		domainAxis.setTickMarkInsideLength(1);
		//设置油漆用于绘制标记
		domainAxis.setTickMarkPaint(Color.red);
		domainAxis.setTickMarksVisible(true);
		
		return jfreechart;
	}

	public static JPanel createDemoPanel(String path ,List<?> l) throws UnsupportedEncodingException {
		JFreeChart jfreechart = createChart(createDataset(l));
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			if(l.size() < 2) {
				ChartUtilities.writeChartAsJPEG(fileOutputStream , jfreechart , 600 , 400);
			}else{
				ChartUtilities.writeChartAsJPEG(fileOutputStream , jfreechart , l.size() * 250 , 400);
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
