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
		String s =  "�Ѱ�װ���շ�";
		String s1 = "��ά�����շ�";
		String s2 = "���������շ�";
		String s3 = "���˶����˷�";
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
		JFreeChart jfreechart = ChartFactory.createBarChart("�շ�ͳ��", null, "���" , categorydataset, PlotOrientation.VERTICAL, true, true, false);
		jfreechart.getTitle().setFont(new Font("����",Font.PLAIN,20));//���ñ�������
		jfreechart.getLegend().setItemFont(new Font("����", Font.PLAIN, 15));//�������ı�������
		jfreechart.getLegend().setPosition(RectangleEdge.LEFT);
		jfreechart.getLegend().setMargin(RectangleInsets.ZERO_INSETS);
		CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();	//��ȡ�߼���������
		//categoryplot.setDomainGridlinePaint(Color.blue);//������������
		categoryplot.setDomainGridlinesVisible(true);
		categoryplot.setRangeAxisLocation(AxisLocation.TOP_OR_LEFT);
		categoryplot.setRangeGridlinePaint(Color.blue);//�����������
		categoryplot.setRangeGridlinesVisible(true);
		categoryplot.setBackgroundPaint(Color.LIGHT_GRAY);//���ñ�����ɫ
		categoryplot.setOutlineVisible(false);
		categoryplot.setDomainGridlinesVisible(true);
		categoryplot.setOutlinePaint(Color.magenta);	//���α߿���ɫ
		categoryplot.getRangeAxis().setLabelFont(new Font("����", Font.PLAIN, 15));//��������
		categoryplot.getDomainAxis().setTickLabelFont(new Font("����", Font.PLAIN, 15));//�����б�����
		categoryplot.getDomainAxis().setLabelFont(new Font("����", Font.PLAIN, 12));//����С��������
		
		//����������б��
		//categoryplot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(0.39269908169872414D));
		//���ӿ�ȡ�ȫ��
		categoryplot.getDomainAxis().setCategoryMargin(0.3D);	
		
		BarRenderer3D renderer3d  = new BarRenderer3D();
		renderer3d.setBaseOutlinePaint(Color.ORANGE);	//�����߿���ɫ
		renderer3d.setWallPaint(Color.gray);//����ǽ����ɫ
		renderer3d.setItemMargin(0.30000000000000000D);//���ӿ�Ⱦֲ�
		renderer3d.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer3d.setBaseItemLabelsVisible(true);
		//��ֵ��ʾ
		renderer3d.setNegativeItemLabelPositionFallback(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_LEFT, TextAnchor.TOP_LEFT, 0.00D));
		//��ֵ��ʾ
		renderer3d.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_LEFT, TextAnchor.TOP_LEFT, 0.00D));
		renderer3d.setItemLabelAnchorOffset(30);
		renderer3d.setDrawBarOutline(true);	//���ñ�־�������Ƿ��͸�ע��ļ�������
		categoryplot.setRenderer(renderer3d);
		
		/*
		 * �����ֵ������ʾ��
		 */
		NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
		numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		numberaxis.setLowerMargin(0.14999999999999999D);
		numberaxis.setUpperMargin(0.14999999999999999D);
		
		/*
		 * ����ʾ��
		 */
		CategoryAxis domainAxis = categoryplot.getDomainAxis();
		domainAxis.setUpperMargin(0.01);
		//������ԵΪ��,ԽС��Y��Խ��
		domainAxis.setLowerMargin(0.005);
		//����ĳ��ȿ̶ȱ��
		domainAxis.setTickMarkOutsideLength(1);
		domainAxis.setTickMarkInsideLength(1);
		//�����������ڻ��Ʊ��
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
