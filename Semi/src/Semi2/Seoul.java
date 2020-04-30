package Semi2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.ImageObserver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.AttributedCharacterIterator;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.util.*;
import java.util.List;

public class Seoul extends JFrame implements ActionListener, MouseListener {
	final static int seoul_city = 25;
	int count = 0;
	JPanel panel;
	String str1 = "", str2 = "";
	JDialog[] dialog = new JDialog[seoul_city];
	JLabel[] label = new JLabel[seoul_city];
	String[] label_str = { "강서구", "중랑구", "마포구", "서대문구", "은평구", "종로구", "성북구", "강북구", "도봉구", "노원구", "동대문구", "광진구", "성동구",
			"중구", "용산구", "양천구", "구로구", "영등포구", "금천구", "관악구", "동작구", "서초구", "강남구", "송파구", "강동구" };
	JPanel[] child_panel = new JPanel[seoul_city];
	JPanel buttonPanel = new JPanel();
	JButton buttonArea = new JButton("명소");
	JButton buttonFood = new JButton("맛집");
	Container dialogContainer;
	boolean food = true;
	
	int[] xgangseo = { 114, 103, 110, 111, 87, 84, 51, 45, 27, 38, 89, 101, 125, 168, 178, 195, 199, 219, 253, 278, 289,
			294, 299, 332, 332, 289, 279, 266, 222, 183, 161, 113, 111 };
	int[] ygangseo = { 309, 315, 338, 354, 370, 399, 410, 442, 450, 475, 492, 514, 495, 499, 484, 484, 487, 520, 532,
			525, 507, 482, 475, 480, 467, 437, 419, 403, 386, 352, 331, 309, 307 };
	int[] xjungnang = { 873, 905, 917, 961, 973, 971, 993, 994, 1005, 1004, 1001, 990, 992, 993, 993, 992, 987, 987,
			970, 970, 956, 960, 960, 939, 928, 889, 874, 875, 876 };
	int[] yjungnang = { 288, 274, 268, 267, 263, 270, 273, 281, 290, 302, 310, 320, 329, 331, 338, 346, 347, 362, 379,
			386, 396, 402, 406, 405, 415, 415, 312, 288, 285 };
	int[] xmapo = { 270, 292, 320, 337, 336, 348, 360, 366, 370, 406, 439, 489, 544, 559, 571, 559, 539, 516, 489, 453,
			416, 374, 360, 323, 307, 294, 283, 268 };
	int[] ymapo = { 387, 373, 373, 360, 352, 343, 356, 356, 363, 384, 411, 447, 451, 444, 470, 497, 518, 531, 516, 500,
			489, 473, 463, 438, 426, 408, 400, 389 };
	int[] xseodaemun = { 412, 439, 487, 546, 581, 558, 551, 567, 559, 545, 542, 533, 519, 512, 484, 474, 435, 430, 415,
			412, 412 };
	int[] yseodaemun = { 383, 407, 440, 447, 422, 406, 392, 350, 326, 321, 304, 304, 311, 327, 338, 353, 355, 355, 365,
			381, 381 };
	int[] xeunpyeong = { 350, 359, 368, 411, 414, 429, 473, 485, 510, 521, 534, 543, 546, 551, 573, 579, 579, 526, 502,
			478, 469, 427, 418, 411, 410, 389, 350 };
	int[] yeunpyeong = { 342, 355, 355, 386, 370, 358, 358, 342, 333, 316, 308, 309, 266, 252, 227, 214, 186, 148, 170,
			168, 181, 177, 253, 260, 325, 347, 343 };
	int[] xjongno = { 579, 555, 552, 549, 561, 571, 572, 556, 566, 587, 630, 636, 649, 745, 745, 711, 680, 629, 630,
			641, 648, 622, 609, 579, 579 };
	int[] yjongno = { 257, 279, 294, 355, 360, 384, 388, 426, 443, 457, 444, 442, 453, 449, 426, 423, 380, 368, 355,
			351, 326, 264, 255, 257, 257 };
	int[] xseongbuk = { 609, 621, 633, 647, 649, 643, 630, 628, 679, 709, 745, 756, 759, 798, 819, 860, 883, 883, 852,
			825, 803, 792, 734, 724, 714, 664, 650, 638, 627, 609 };
	int[] yseongbuk = { 254, 262, 296, 326, 340, 351, 353, 368, 380, 423, 427, 421, 406, 387, 360, 348, 344, 319, 313,
			284, 318, 324, 324, 319, 287, 258, 254, 242, 252, 252 };
	int[] xgangbuk = { 636, 645, 668, 713, 723, 731, 786, 799, 823, 752, 736, 707, 704, 711, 713, 707, 673, 665, 639,
			642, 638 };
	int[] ygangbuk = { 241, 252, 259, 286, 318, 323, 323, 318, 284, 209, 209, 185, 179, 169, 130, 102, 110, 141, 169,
			236, 241 };
	int[] xdobong = { 706, 713, 710, 707, 707, 734, 753, 808, 828, 831, 836, 842, 829, 830, 841, 842, 829, 818, 781,
			778, 773, 731, 723, 721, 715, 715, 706 };
	int[] ydobong = { 104, 130, 170, 177, 187, 207, 210, 263, 261, 243, 233, 179, 150, 132, 109, 87, 88, 78, 76, 64, 59,
			59, 63, 65, 76, 99, 102 };
	int[] xnowon = { 842, 841, 829, 828, 843, 838, 832, 831, 829, 808, 850, 883, 925, 968, 979, 978, 974, 978, 993,
			1001, 1001, 995, 990, 951, 945, 943, 946, 948, 961, 961, 943, 957, 957, 936, 897, 881, 871, 852, 846, 843,
			843 };
	int[] ynowon = { 87, 108, 135, 150, 176, 228, 239, 243, 260, 262, 312, 320, 301, 300, 297, 292, 288, 278, 270, 265,
			253, 246, 225, 219, 204, 191, 186, 169, 161, 140, 120, 102, 90, 85, 64, 63, 74, 80, 82, 87, 87 };
	int[] xdongdaemun = { 899, 880, 815, 809, 775, 769, 756, 748, 747, 756, 758, 799, 808, 821, 849, 882, 896 };
	int[] ydongdaemun = { 446, 480, 462, 447, 445, 452, 454, 448, 426, 418, 405, 386, 368, 361, 351, 345, 447 };
	int[] xgwangjin = { 897, 881, 875, 861, 850, 841, 869, 918, 928, 950, 972, 977, 984, 963, 955, 968, 967, 950, 930,
			897 };
	int[] ygwangjin = { 448, 480, 508, 531, 540, 569, 579, 577, 575, 551, 524, 519, 487, 485, 463, 445, 439, 438, 446,
			448 };
	int[] xseongdong = { 745, 745, 736, 721, 706, 716, 745, 785, 814, 841, 849, 849, 861, 870, 876, 879, 816, 810, 773,
			769, 755, 746 };
	int[] yseongdong = { 448, 468, 482, 493, 516, 551, 547, 551, 561, 572, 551, 540, 529, 517, 499, 480, 461, 448, 446,
			454, 452, 447 };
	int[] xjung = { 586, 564, 576, 642, 655, 688, 704, 721, 745, 746, 686, 647, 637, 586 };
	int[] yjung = { 456, 474, 500, 498, 508, 510, 518, 495, 470, 449, 449, 452, 445, 456 };
	int[] xyongsan = { 576, 560, 543, 520, 575, 630, 689, 717, 707, 688, 657, 643, 574 };
	int[] yyongsan = { 500, 531, 550, 562, 613, 614, 571, 552, 518, 510, 510, 501, 501 };
	int[] xyangcheon = { 175, 181, 183, 171, 199, 204, 228, 254, 278, 284, 294, 326, 339, 337, 357, 357, 337, 306, 297,
			297, 284, 258, 227, 206, 199, 181, 175 };
	int[] yyangcheon = { 529, 537, 601, 617, 621, 631, 631, 613, 615, 629, 631, 633, 610, 571, 556, 544, 509, 506, 514,
			538, 552, 559, 551, 516, 513, 515, 528 };
	int[] xguro = { 173, 181, 158, 171, 151, 193, 203, 224, 270, 273, 296, 313, 314, 359, 378, 378, 368, 360, 336, 324,
			294, 284, 278, 255, 230, 204, 199, 171 };
	int[] yguro = { 618, 625, 670, 696, 735, 732, 736, 737, 700, 690, 674, 682, 701, 699, 691, 663, 655, 626, 615, 633,
			632, 629, 615, 615, 631, 631, 621, 617 };
	int[] xyeongdeungpo = { 337, 338, 357, 359, 335, 337, 362, 370, 369, 376, 377, 396, 405, 406, 417, 445, 454, 454,
			480, 458, 449, 446, 375, 337 };
	int[] yyeongdeungpo = { 496, 509, 542, 555, 572, 612, 623, 647, 655, 661, 691, 701, 699, 682, 674, 668, 654, 634,
			600, 586, 561, 545, 521, 495 };
	int[] xgeumcheon = { 314, 331, 338, 350, 377, 407, 427, 437, 451, 455, 449, 438, 429, 420, 409, 405, 395, 377, 363,
			314 };
	int[] ygeumcheon = { 701, 738, 762, 762, 842, 842, 838, 818, 813, 810, 795, 791, 780, 713, 709, 700, 700, 691, 699,
			700 };
	int[] xgwanak = { 404, 410, 420, 429, 437, 449, 456, 450, 469, 474, 487, 545, 584, 639, 652, 625, 625, 610, 591,
			567, 559, 529, 462, 456, 441, 429, 405 };
	int[] ygwanak = { 701, 710, 714, 777, 793, 795, 808, 812, 816, 834, 839, 839, 822, 779, 777, 738, 723, 728, 728,
			713, 683, 674, 671, 687, 689, 689, 700 };
	int[] xdongjak = { 480, 456, 453, 447, 417, 408, 405, 430, 444, 455, 461, 529, 567, 590, 608, 622, 620, 629, 621,
			601, 598, 568, 536, 504, 480 };
	int[] ydongjak = { 599, 633, 654, 667, 676, 683, 699, 691, 688, 685, 672, 672, 713, 729, 727, 720, 711, 664, 648,
			646, 633, 628, 600, 600, 596 };
	int[] xseocho = { 597, 600, 618, 629, 620, 625, 624, 651, 658, 666, 675, 675, 678, 699, 712, 738, 761, 763, 772,
			774, 811, 851, 858, 895, 901, 906, 922, 924, 927, 927, 946, 936, 920, 911, 911, 893, 870, 860, 851, 812,
			805, 795, 773, 747, 740, 726, 721, 704, 644, 621, 597 };
	int[] yseocho = { 633, 645, 646, 664, 708, 724, 739, 774, 770, 767, 777, 787, 792, 791, 779, 765, 769, 807, 829,
			847, 863, 869, 842, 834, 828, 819, 817, 809, 807, 797, 792, 781, 773, 765, 747, 741, 743, 745, 759, 766,
			751, 720, 705, 689, 649, 636, 610, 580, 625, 628, 630 };
	int[] xgangnam = { 705, 723, 727, 742, 744, 750, 794, 813, 848, 861, 890, 910, 912, 924, 935, 946, 962, 967, 986,
			1001, 1020, 995, 988, 962, 951, 901, 875, 863, 863, 863, 830, 803, 774, 745, 723, 705 };
	int[] ygangnam = { 581, 608, 633, 648, 680, 691, 718, 766, 761, 746, 739, 746, 765, 776, 779, 792, 794, 789, 789,
			771, 768, 732, 703, 692, 676, 665, 651, 639, 598, 594, 584, 573, 563, 563, 566, 581 };
	int[] xsongpa = { 864, 865, 875, 912, 917, 951, 962, 988, 995, 1022, 1033, 1058, 1065, 1063, 1068, 1086, 1092, 1097,
			1104, 1115, 1072, 1061, 1063, 1054, 1071, 1056, 1051, 1028, 1021, 1016, 1014, 1004, 995, 980, 949, 940, 923,
			905, 880, 864 };
	int[] ysongpa = { 595, 636, 654, 670, 670, 676, 691, 706, 731, 767, 746, 746, 743, 733, 721, 717, 709, 689, 679,
			674, 655, 646, 635, 630, 606, 602, 596, 593, 577, 539, 536, 533, 526, 549, 580, 587, 593, 593, 594, 593 };
	int[] xgangdong = { 997, 1005, 1013, 1016, 1009, 1023, 1030, 1049, 1059, 1071, 1099, 1100, 1175, 1183, 1176, 1177,
			1172, 1174, 1183, 1177, 1156, 1157, 1096, 1052, 1008, 997 };
	int[] ygangdong = { 526, 533, 533, 548, 570, 580, 596, 596, 604, 604, 576, 551, 532, 522, 513, 499, 491, 487, 471,
			455, 448, 432, 458, 461, 488, 527 };

	public Seoul() {
		setArr(xjongno, -5);
		setArr(yjongno, -30);
		setArr(xseongbuk, -5);
		setArr(yseongbuk, -30);
		setArr(xgangbuk, -5);
		setArr(ygangbuk, -30);
		setArr(xdobong, -5);
		setArr(ydobong, -30);
		setArr(xnowon, -7);
		setArr(ynowon, -30);
		setArr(xdongdaemun, -7);
		setArr(ydongdaemun, -30);
		setArr(xgwangjin, -7);
		setArr(ygwangjin, -30);
		setArr(xseongdong, -7);
		setArr(yseongdong, -30);
		setArr(xjung, -7);
		setArr(yjung, -30);
		setArr(xyongsan, -7);
		setArr(yyongsan, -30);
		setArr(xyangcheon, -7);
		setArr(yyangcheon, -30);
		setArr(xguro, -7);
		setArr(yguro, -30);
		setArr(xyeongdeungpo, -7);
		setArr(yyeongdeungpo, -30);
		setArr(xgeumcheon, -7);
		setArr(ygeumcheon, -30);
		setArr(xgwanak, -7);
		setArr(ygwanak, -30);
		setArr(xdongjak, -7);
		setArr(ydongjak, -30);
		setArr(xseocho, -7);
		setArr(yseocho, -30);
		setArr(xgangnam, -7);
		setArr(ygangnam, -30);
		setArr(xsongpa, -7);
		setArr(ysongpa, -30);
		setArr(xgangdong, -7);
		setArr(ygangdong, -30);

		panel = new JPanel() {
			protected void paintComponent(Graphics g) {
				Image image = new ImageIcon("image\\map\\서울 보라색 그림.PNG").getImage();
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
				setOpaque(false);
			}
		};

		// init Label
		for (int i = 0; i < label.length; i++) {
			label[i] = new JLabel(label_str[i], JLabel.CENTER);
			panel.add(label[i]);
			panel.setLayout(null);
			label[i].setVisible(true);
			label[i].setFont(new Font("NanumGothicExtraBold", Font.BOLD, 17));
			label[i].setForeground(new Color(241, 244, 251));
		}
		label[0].setBounds(124, 380, 80, 80);
		label[1].setBounds(900, 300, 80, 80);
		label[2].setBounds(360, 400, 80, 80);
		label[3].setBounds(450, 350, 80, 80);
		label[4].setBounds(450, 200, 80, 80);
		label[5].setBounds(550, 310, 80, 80);
		label[6].setBounds(690, 300, 80, 80);
		label[7].setBounds(660, 160, 80, 80);
		label[8].setBounds(730, 80, 80, 80);
		label[9].setBounds(850, 120, 80, 80);
		label[10].setBounds(780, 350, 80, 80);
		label[11].setBounds(870, 450, 80, 80);
		label[12].setBounds(750, 430, 80, 80);
		label[13].setBounds(600, 420, 60, 60);
		label[14].setBounds(580, 480, 80, 80);
		label[15].setBounds(220, 520, 60, 60);
		label[16].setBounds(220, 600, 60, 60);
		label[17].setBounds(350, 520, 80, 80);
		label[18].setBounds(350, 700, 60, 60);
		label[19].setBounds(470, 670, 80, 80);
		label[20].setBounds(500, 585, 60, 60);
		label[21].setBounds(630, 635, 80, 80);
		label[22].setBounds(800, 635, 80, 80);
		label[23].setBounds(950, 580, 80, 80);
		label[24].setBounds(1050, 450, 80, 80);
		
		for (int i = 0; i < label.length; i++) {
			label[i].addMouseListener(this);
		}
		
		
		//init buttonPanel
		buttonPanel.setLayout(new GridLayout(0,2,0,0));
		buttonPanel.add(buttonArea);
		buttonPanel.add(buttonFood);
		buttonArea.setFont(new Font("NanumGothicExtraBold", Font.BOLD, 17));
		buttonFood.setFont(new Font("NanumGothicExtraBold", Font.BOLD, 17));
		buttonArea.addActionListener(this);
		buttonFood.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==buttonArea) {	
			System.out.println(count);
			new Crawling(count);
			
			try {
				Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if(e.getSource()==buttonFood) {
			new Crawling(count, food);
			try {
				Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	private void setArr(int[] a, int num) {
		for (int i = 0; i < a.length; i++) {
			a[i] = a[i] + num;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JPanel dialogPanel = null;
		if (e.getSource() == label[0]) {
			child_panel[0] = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					g.setColor(new Color(63, 93, 152));
					Polygon p = new Polygon(xgangseo, ygangseo, xgangseo.length);
					g.drawPolygon(p);
					g.fillPolygon(p);
				}
			};
			count = 0;
			dialogPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					Image image = new ImageIcon("image\\seoul\\강서구 허준 박물관.jpg").getImage();
					g.drawImage(image, 0, 0, dialog[0].getWidth(), dialog[0].getHeight(), this);
					setOpaque(false);
				}
			};
		} else if (e.getSource() == label[1]) {
			child_panel[1] = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					g.setColor(new Color(63, 93, 152));
					Polygon p = new Polygon(xjungnang, yjungnang, xjungnang.length);
					g.drawPolygon(p);
					g.fillPolygon(p);
				}
			};
			count = 1;
			dialogPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					Image image = new ImageIcon("image\\seoul\\중랑구 용마산.jpg").getImage();
					g.drawImage(image, 0, 0, dialog[1].getWidth(), dialog[1].getHeight(), this);
					setOpaque(false);
				}
			};
		} else if (e.getSource() == label[2]) {
			child_panel[2] = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					g.setColor(new Color(63, 93, 152));
					Polygon p = new Polygon(xmapo, ymapo, xmapo.length);
					g.drawPolygon(p);
					g.fillPolygon(p);
				}
			};
			count = 2;
			dialogPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					Image image = new ImageIcon("image\\seoul\\마포구 난지 한강공원.jpg").getImage();
					g.drawImage(image, 0, 0, dialog[2].getWidth(), dialog[2].getHeight(), this);
					setOpaque(false);
				}
			};
		} else if (e.getSource() == label[3]) {
			child_panel[3] = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					g.setColor(new Color(63, 93, 152));
					Polygon p = new Polygon(xseodaemun, yseodaemun, xseodaemun.length);
					g.drawPolygon(p);
					g.fillPolygon(p);
				}
			};
			count = 3;
			dialogPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					Image image = new ImageIcon("image\\seoul\\서대문구 독립문.jpg").getImage();
					g.drawImage(image, 0, 0, dialog[3].getWidth(), dialog[3].getHeight(), this);
					setOpaque(false);
				}
			};
		} else if (e.getSource() == label[4]) {
			child_panel[4] = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					g.setColor(new Color(63, 93, 152));
					Polygon p = new Polygon(xeunpyeong, yeunpyeong, xeunpyeong.length);
					g.drawPolygon(p);
					g.fillPolygon(p);
				}
			};
			count = 4;
			dialogPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					Image image = new ImageIcon("image\\seoul\\은평구 진관사.jpg").getImage();
					g.drawImage(image, 0, 0, dialog[4].getWidth(), dialog[4].getHeight(), this);
					setOpaque(false);
				}
			};
	
		} else if (e.getSource() == label[5]) {
			child_panel[5] = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					g.setColor(new Color(63, 93, 152));
					Polygon p = new Polygon(xjongno, yjongno, xjongno.length);
					g.drawPolygon(p);
					g.fillPolygon(p);
				}
			};
			count = 5;
			dialogPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					Image image = new ImageIcon("image\\seoul\\종로구 북촌 한옥마을.jpg").getImage();
					g.drawImage(image, 0, 0, dialog[5].getWidth(), dialog[5].getHeight(), this);
					setOpaque(false);
				}
			};
		
		} else if (e.getSource() == label[6]) {
			child_panel[6] = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					g.setColor(new Color(63, 93, 152));
					Polygon p = new Polygon(xseongbuk, yseongbuk, xseongbuk.length);
					g.drawPolygon(p);
					g.fillPolygon(p);
				}
			};
			count = 6;
			dialogPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					Image image = new ImageIcon("image\\seoul\\성북구 길상사.jpg").getImage();
					g.drawImage(image, 0, 0, dialog[6].getWidth(), dialog[6].getHeight(), this);
					setOpaque(false);
				}
			};
		} else if (e.getSource() == label[7]) {
			child_panel[7] = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					g.setColor(new Color(63, 93, 152));
					Polygon p = new Polygon(xgangbuk, ygangbuk, xgangbuk.length);
					g.drawPolygon(p);
					g.fillPolygon(p);
				}
			};
			count = 7;
			dialogPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					Image image = new ImageIcon("image\\seoul\\강북구 북서울꿈의숲.jpg").getImage();
					g.drawImage(image, 0, 0, dialog[7].getWidth(), dialog[7].getHeight(), this);
					setOpaque(false);
				}
			};
			
		} else if (e.getSource() == label[8]) {
			child_panel[8] = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					g.setColor(new Color(63, 93, 152));
					Polygon p = new Polygon(xdobong, ydobong, xdobong.length);
					g.drawPolygon(p);
					g.fillPolygon(p);
				}
			};
			count = 8;
			dialogPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					Image image = new ImageIcon("image\\seoul\\도봉구 둘리뮤지엄.jpg").getImage();
					g.drawImage(image, 0, 0, dialog[8].getWidth(), dialog[8].getHeight(), this);
					setOpaque(false);
				}
			};
		} else if (e.getSource() == label[9]) {
			child_panel[9] = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					g.setColor(new Color(63, 93, 152));
					Polygon p = new Polygon(xnowon, ynowon, xnowon.length);
					g.drawPolygon(p);
					g.fillPolygon(p);
				}
			};
			count = 9;
			dialogPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					Image image = new ImageIcon("image\\seoul\\노원구 수락산.png").getImage();
					g.drawImage(image, 0, 0, dialog[9].getWidth(), dialog[9].getHeight(), this);
					setOpaque(false);
				}
			};
		} else if (e.getSource() == label[10]) {
			child_panel[10] = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					g.setColor(new Color(63, 93, 152));
					Polygon p = new Polygon(xdongdaemun, ydongdaemun, xdongdaemun.length);
					g.drawPolygon(p);
					g.fillPolygon(p);
				}
			};
			count = 10;
			dialogPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					Image image = new ImageIcon("image\\seoul\\동대문구 세종대왕기념관.jpg").getImage();
					g.drawImage(image, 0, 0, dialog[10].getWidth(), dialog[10].getHeight(), this);
					setOpaque(false);
				}
			};
		} else if (e.getSource() == label[11]) {
			child_panel[11] = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					g.setColor(new Color(63, 93, 152));
					Polygon p = new Polygon(xgwangjin, ygwangjin, xgwangjin.length);
					g.drawPolygon(p);
					g.fillPolygon(p);
				}
			};
			count = 11;
			dialogPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					Image image = new ImageIcon("image\\seoul\\광진구 뚝섬한강공원.jpg").getImage();
					g.drawImage(image, 0, 0, dialog[11].getWidth(), dialog[11].getHeight(), this);
					setOpaque(false);
				}
			};
		
		} else if (e.getSource() == label[12]) {
			child_panel[12] = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					g.setColor(new Color(63, 93, 152));
					Polygon p = new Polygon(xseongdong, yseongdong, xseongdong.length);
					g.drawPolygon(p);
					g.fillPolygon(p);
				}
			};
			count = 12;
			dialogPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					Image image = new ImageIcon("image\\seoul\\성동구 서울숲공원.jpg").getImage();
					g.drawImage(image, 0, 0, dialog[12].getWidth(), dialog[12].getHeight(), this);
					setOpaque(false);
				}
			};
		} else if (e.getSource() == label[13]) {
			child_panel[13] = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					g.setColor(new Color(63, 93, 152));
					Polygon p = new Polygon(xjung, yjung, xjung.length);
					g.drawPolygon(p);
					g.fillPolygon(p);
				}
			};
			count = 13;
			dialogPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					Image image = new ImageIcon("image\\seoul\\중구 숭례문.jpg").getImage();
					g.drawImage(image, 0, 0, dialog[13].getWidth(), dialog[13].getHeight(), this);
					setOpaque(false);
				}
			};
			
		} else if (e.getSource() == label[14]) {
			child_panel[14] = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					g.setColor(new Color(63, 93, 152));
					Polygon p = new Polygon(xyongsan, yyongsan, xyongsan.length);
					g.drawPolygon(p);
					g.fillPolygon(p);
				}
			};
			count = 14;
			dialogPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					Image image = new ImageIcon("image\\seoul\\용산구 전쟁기념관.png").getImage();
					g.drawImage(image, 0, 0, dialog[14].getWidth(), dialog[14].getHeight(), this);
					setOpaque(false);
				}
			};
			
		} else if (e.getSource() == label[15]) {
			child_panel[15] = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					g.setColor(new Color(63, 93, 152));
					Polygon p = new Polygon(xyangcheon, yyangcheon, xyangcheon.length);
					g.drawPolygon(p);
					g.fillPolygon(p);
				}
			};
			count = 15;
			dialogPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					Image image = new ImageIcon("image\\seoul\\양천구 서서울호수공원.jpg").getImage();
					g.drawImage(image, 0, 0, dialog[15].getWidth(), dialog[15].getHeight(), this);
					setOpaque(false);
				}
			};
			
		} else if (e.getSource() == label[16]) {
			child_panel[16] = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					g.setColor(new Color(63, 93, 152));
					Polygon p = new Polygon(xguro, yguro, xguro.length);
					g.drawPolygon(p);
					g.fillPolygon(p);
				}
			};
			count = 16;
			dialogPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					Image image = new ImageIcon("image\\seoul\\구로구 궁동저수지생태공원.png").getImage();
					g.drawImage(image, 0, 0, dialog[16].getWidth(), dialog[16].getHeight(), this);
					setOpaque(false);
				}
			};
			
		} else if (e.getSource() == label[17]) {
			child_panel[17] = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					g.setColor(new Color(63, 93, 152));
					Polygon p = new Polygon(xyeongdeungpo, yyeongdeungpo, xyeongdeungpo.length);
					g.drawPolygon(p);
					g.fillPolygon(p);
				}
			};
			count = 17;
			dialogPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					Image image = new ImageIcon("image\\seoul\\영등포구 신길벚꽃거리.jpg").getImage();
					g.drawImage(image, 0, 0, dialog[17].getWidth(), dialog[17].getHeight(), this);
					setOpaque(false);
				}
			};
			
		} else if (e.getSource() == label[18]) {
			child_panel[18] = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					g.setColor(new Color(63, 93, 152));
					Polygon p = new Polygon(xgeumcheon, ygeumcheon, xgeumcheon.length);
					g.drawPolygon(p);
					g.fillPolygon(p);
				}
			};
			count = 18;
			dialogPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					Image image = new ImageIcon("image\\seoul\\금천구 금천폭포공원.jpg").getImage();
					g.drawImage(image, 0, 0, dialog[18].getWidth(), dialog[18].getHeight(), this);
					setOpaque(false);
				}
			};
			
		} else if (e.getSource() == label[19]) {
			child_panel[19] = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					g.setColor(new Color(63, 93, 152));
					Polygon p = new Polygon(xgwanak, ygwanak, xgwanak.length);
					g.drawPolygon(p);
					g.fillPolygon(p);
				}
			};
			count = 19;
			dialogPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					Image image = new ImageIcon("image\\seoul\\관악구 낙성대공원.jpg").getImage();
					g.drawImage(image, 0, 0, dialog[19].getWidth(), dialog[19].getHeight(), this);
					setOpaque(false);
				}
			};
			
		} else if (e.getSource() == label[20]) {
			child_panel[20] = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					g.setColor(new Color(63, 93, 152));
					Polygon p = new Polygon(xdongjak, ydongjak, xdongjak.length);
					g.drawPolygon(p);
					g.fillPolygon(p);
				}
			};
			count = 20;
			dialogPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					Image image = new ImageIcon("image\\seoul\\동작구 보라매공원.jpg").getImage();
					g.drawImage(image, 0, 0, dialog[20].getWidth(), dialog[20].getHeight(), this);
					setOpaque(false);
				}
			};
			
		} else if (e.getSource() == label[21]) {
			child_panel[21] = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					g.setColor(new Color(63, 93, 152));
					Polygon p = new Polygon(xseocho, yseocho, xseocho.length);
					g.drawPolygon(p);
					g.fillPolygon(p);
				}
			};
			count = 21;
			dialogPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					Image image = new ImageIcon("image\\seoul\\서초구 반포한강공원.jpg").getImage();
					g.drawImage(image, 0, 0, dialog[21].getWidth(), dialog[21].getHeight(), this);
					setOpaque(false);
				}
			};
			
		} else if (e.getSource() == label[22]) {
			child_panel[22] = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					g.setColor(new Color(63, 93, 152));
					Polygon p = new Polygon(xgangnam, ygangnam, xgangnam.length);
					g.drawPolygon(p);
					g.fillPolygon(p);
				}
			};
			count = 22;
			dialogPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					Image image = new ImageIcon("image\\seoul\\강남구 가로수길.jpg").getImage();
					g.drawImage(image, 0, 0, dialog[22].getWidth(), dialog[22].getHeight(), this);
					setOpaque(false);
				}
			};
			
		} else if (e.getSource() == label[23]) {
			child_panel[23] = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					g.setColor(new Color(63, 93, 152));
					Polygon p = new Polygon(xsongpa, ysongpa, xsongpa.length);
					g.drawPolygon(p);
					g.fillPolygon(p);
				}
			};
			count = 23;
			dialogPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					Image image = new ImageIcon("image\\seoul\\송파구 석촌호수.jpg").getImage();
					g.drawImage(image, 0, 0, dialog[23].getWidth(), dialog[23].getHeight(), this);
					setOpaque(false);
				}
			};
			
		} else if (e.getSource() == label[24]) {
			child_panel[24] = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					g.setColor(new Color(63, 93, 152));
					Polygon p = new Polygon(xgangdong, ygangdong, xgangdong.length);
					g.drawPolygon(p);
					g.fillPolygon(p);
				}
			};
			count = 24;
			dialogPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					Image image = new ImageIcon("image\\seoul\\강동구 천호공원.jpg").getImage();
					g.drawImage(image, 0, 0, dialog[24].getWidth(), dialog[24].getHeight(), this);
					setOpaque(false);
				}
			};
		}
		//브레이크포인트
		
		panel.add(child_panel[count]);
		label[count].setForeground(new Color(245, 217, 127));
		child_panel[count].setBounds(0, 0, 1200, 900);
		child_panel[count].setVisible(true);
		child_panel[count].setOpaque(false);
		dialog[count] = new JDialog();
		dialog[count].setLayout(null);
		dialogContainer = dialog[count].getContentPane();
		dialogContainer.setLayout(new BorderLayout());
		dialogContainer.add("Center", dialogPanel);
		dialogContainer.add("South", buttonPanel);
		dialogPanel.setLayout(null);
		dialog[count].setTitle(label_str[count]);
		dialog[count].addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				panel.remove(child_panel[count]);
				label[count].setForeground(new Color(241, 244, 251));
				panel.repaint();
				dialog[count].dispose();
			}
		});
		dialog[count].setBounds(1500, 108, 400, 430);
		dialog[count].setVisible(true);
		revalidate();
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
	

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
}