package com.cetian.base.util;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 图片工具类
 * 
 * @author zangrong
 *
 */
public class ImageUtil {

	private static Logger log = LoggerFactory.getLogger(ImageUtil.class);

	/**
	 * 几种常见的图片格式
	 */
	public static String IMAGE_TYPE_GIF = "gif";// 图形交换格式
	public static String IMAGE_TYPE_JPG = "jpg";// 联合照片专家组
	public static String IMAGE_TYPE_JPEG = "jpeg";// 联合照片专家组
	public static String IMAGE_TYPE_BMP = "bmp";// 英文Bitmap（位图）的简写，它是Windows操作系统中的标准图像文件格式
	public static String IMAGE_TYPE_PNG = "png";// 可移植网络图形
	public static String IMAGE_TYPE_PSD = "psd";// Photoshop的专用格式Photoshop

	/**
	 * 
	 * @Title: bufferedImageToInputStream
	 * @Description: 缓存图片转输入流
	 * @param image
	 * @return: InputStream
	 * @throws:
	 */
	public static InputStream bufferedImageToInputStream(BufferedImage image) {
		InputStream is = null;
		image.flush();
		try {
			ByteArrayOutputStream bs = new ByteArrayOutputStream();
			ImageOutputStream imOut = ImageIO.createImageOutputStream(bs);
			ImageIO.write(image, "png", imOut);
			is = new ByteArrayInputStream(bs.toByteArray());
		} catch (IOException e) {
			log.error("缓存图片转输入流异常", e);
		}
		return is;
	}

	/**
	 * 
	 * @Title: scaleToSquare
	 * @Description: 把图片转换成正方形，长宽比例不变，空白区域保持透明
	 * @param image
	 * @param size
	 * @return: void
	 * @throws:
	 */
	public static final BufferedImage scaleToSquare(BufferedImage image, int size) {
		// 计算图片缩放后的四项参数
		int x = 0;
		int y = 0;
		int newWidth = 0;
		int newHeight = 0;
		// 原图的宽高
		int srcWidth = image.getWidth();
		int srcHeight = image.getHeight();

		// 输出的宽高比例
		float outRatio = (float) size / (float) size;
		// 原图的宽高比例
		float srcRatio = (float) srcWidth / (float) srcHeight;
		if (srcRatio == outRatio) {
			// 如果比例相等，则不需要处理
			newWidth = size;
			newHeight = size;
		} else if (srcRatio < outRatio) {
			// 原图宽高比例小于输出比例
			newHeight = size;
			newWidth = (int) (srcWidth * ((float) size / (float) srcHeight));
			y = 0;
			x = (size - newWidth) / 2;
		} else {
			// 原图宽高比例大于输出比例
			newWidth = size;
			newHeight = (int) (srcHeight * ((float) size / (float) srcWidth));
			x = 0;
			y = (size - newHeight) / 2;
		}

		// 创建新的背景图片
		BufferedImage background = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = background.createGraphics();
		// ---------- 增加下面的代码使得背景透明 -----------------
		background = g2d.getDeviceConfiguration().createCompatibleImage(size, size, Transparency.TRANSLUCENT);
		g2d.dispose();
		// 在底板上绘制原图
		g2d = background.createGraphics();
		g2d.drawImage(image, x, y, newWidth, newHeight, null);
		g2d.dispose();
		background.flush();

		return background;
	}

	/**
	 * 图片缩放，宽高比例不变，图片满足最短边长（即在图片比例不变的情况下充满整个指定区域），空白区域保持透明
	 * 
	 * @param srcImageFile
	 * @param outputImageFile
	 * @param width
	 *            输出图片宽
	 * @param height
	 *            输出图片高
	 */
	public final static void scale(String srcImageFile, String outputImageFile, int width, int height) {
		try {
			// 原始图片
			BufferedImage srcImg = ImageIO.read(new File(srcImageFile));

			// 创建底板图片
			Graphics2D g2d = srcImg.createGraphics();
			// 设置背景保持透明
			BufferedImage backImage = g2d.getDeviceConfiguration().createCompatibleImage(width, height,
					Transparency.TRANSLUCENT);
			g2d.dispose();

			// 计算图片缩放后的四项参数
			int x = 0;
			int y = 0;
			int newWidth = 0;
			int newHeight = 0;
			// 原图的宽高
			int srcWidth = srcImg.getWidth();
			int srcHeight = srcImg.getHeight();

			// 输出的宽高比例
			float outRatio = (float) width / (float) height;
			// 原图的宽高比例
			float srcRatio = (float) srcWidth / (float) srcHeight;
			if (srcRatio == outRatio) {
				// 如果比例相等，则不需要处理
				newWidth = width;
				newHeight = height;
			} else if (srcRatio < outRatio) {
				// 原图宽高比例小于输出比例
				newHeight = height;
				newWidth = (int) (srcWidth * ((float) height / (float) srcHeight));
				y = 0;
				x = (width - newWidth) / 2;
			} else {
				// 原图宽高比例大于输出比例
				newWidth = width;
				newHeight = (int) (srcHeight * ((float) width / (float) srcWidth));
				x = 0;
				y = (height - newHeight) / 2;
			}

			// 在底板上绘制原图
			g2d = backImage.createGraphics();
			g2d.drawImage(srcImg, x, y, newWidth, newHeight, null);

			g2d.dispose();
			writeImageLocal(outputImageFile, backImage);
		} catch (Exception e) {
			log.error("", e);
		}
	}

	/**
	 * 图片缩放，宽高比例不变，设置图片宽和高的最大值 比如图片原始尺寸 400*300，此时如果设置max为200，则修改后的图片尺寸为200*150
	 * 
	 * @param srcImageFile
	 * @param outputImageFile
	 * @param max
	 *            最长的宽或者高，即宽和高的分辨率不能超出给定的这个数值
	 */
	public final static void scale(String srcImageFile, String outputImageFile, int max) {
		try {
			// 原图片
			BufferedImage srcImg = ImageIO.read(new File(srcImageFile));

			int width = srcImg.getWidth();
			int height = srcImg.getHeight();

			// 获取图片原始的宽和高里较长的那个数值，比如宽是200，高是150，则获取数值为200
			int imgMax = width > height ? width : height;

			// 计算图片最长值跟 我们需要的最长值的比例
			float rate = (float) max / (float) imgMax;

			// 计算出来的新的宽和高
			int newWidth = (int) (rate * (float) width);
			int newHeight = (int) (rate * (float) height);

			scale(srcImageFile, outputImageFile, newWidth, newHeight);
		} catch (Exception e) {
			log.error("", e);
		}
	}

	/**
	 * 缩放图像（按比例缩放）
	 * 
	 * @param srcImageFile
	 *            源图像文件地址
	 * @param result
	 *            缩放后的图像地址
	 * @param scale
	 *            缩放比例 0< <1是缩小，1<是放大
	 */
	public final static void scale(String srcImageFile, String result, float scale) {
		try {
			BufferedImage src = ImageIO.read(new File(srcImageFile)); // 读入文件
			int width = src.getWidth(); // 得到源图宽
			int height = src.getHeight(); // 得到源图长
			width = (int) (width * scale);
			height = (int) (height * scale);
			Image image = src.getScaledInstance(width, height, Image.SCALE_DEFAULT);
			BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			g.drawImage(image, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			ImageIO.write(tag, "JPEG", new File(result));// 输出到文件流
		} catch (IOException e) {
			log.error("", e);
		}
	}

	/**
	 * 图像切割(按指定起点坐标和宽高切割)
	 * 
	 * @param srcImageFile
	 *            源图像地址
	 * @param result
	 *            切片后的图像地址
	 * @param x
	 *            目标切片起点坐标X
	 * @param y
	 *            目标切片起点坐标Y
	 * @param width
	 *            目标切片宽度
	 * @param height
	 *            目标切片高度
	 */
	public final static void cut(String srcImageFile, String result, int x, int y, int width, int height) {
		try {
			// 读取源图像
			BufferedImage bi = ImageIO.read(new File(srcImageFile));
			int srcWidth = bi.getHeight(); // 源图宽度
			int srcHeight = bi.getWidth(); // 源图高度
			if (srcWidth > 0 && srcHeight > 0) {
				Image image = bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);
				// 四个参数分别为图像起点坐标和宽高
				// 即: CropImageFilter(int x,int y,int width,int height)
				ImageFilter cropFilter = new CropImageFilter(x, y, width, height);
				Image img = Toolkit.getDefaultToolkit()
						.createImage(new FilteredImageSource(image.getSource(), cropFilter));
				BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				Graphics g = tag.getGraphics();
				g.drawImage(img, 0, 0, width, height, null); // 绘制切割后的图
				g.dispose();
				// 输出为文件
				ImageIO.write(tag, "JPEG", new File(result));
			}
		} catch (Exception e) {
			log.error("", e);
		}
	}

	/**
	 * 图像切割（指定切片的行数和列数）
	 * 
	 * @param srcImageFile
	 *            源图像地址
	 * @param descDir
	 *            切片目标文件夹
	 * @param rows
	 *            目标切片行数。默认2，必须是范围 [1, 20] 之内
	 * @param cols
	 *            目标切片列数。默认2，必须是范围 [1, 20] 之内
	 */
	public final static void cut2(String srcImageFile, String descDir, int rows, int cols) {
		try {
			if (rows <= 0 || rows > 20)
				rows = 2; // 切片行数
			if (cols <= 0 || cols > 20)
				cols = 2; // 切片列数
			// 读取源图像
			BufferedImage bi = ImageIO.read(new File(srcImageFile));
			int srcWidth = bi.getHeight(); // 源图宽度
			int srcHeight = bi.getWidth(); // 源图高度
			if (srcWidth > 0 && srcHeight > 0) {
				Image img;
				ImageFilter cropFilter;
				Image image = bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);
				int destWidth = srcWidth; // 每张切片的宽度
				int destHeight = srcHeight; // 每张切片的高度
				// 计算切片的宽度和高度
				if (srcWidth % cols == 0) {
					destWidth = srcWidth / cols;
				} else {
					destWidth = (int) Math.floor(srcWidth / cols) + 1;
				}
				if (srcHeight % rows == 0) {
					destHeight = srcHeight / rows;
				} else {
					destHeight = (int) Math.floor(srcWidth / rows) + 1;
				}
				// 循环建立切片
				// 改进的想法:是否可用多线程加快切割速度
				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < cols; j++) {
						// 四个参数分别为图像起点坐标和宽高
						// 即: CropImageFilter(int x,int y,int width,int height)
						cropFilter = new CropImageFilter(j * destWidth, i * destHeight, destWidth, destHeight);
						img = Toolkit.getDefaultToolkit()
								.createImage(new FilteredImageSource(image.getSource(), cropFilter));
						BufferedImage tag = new BufferedImage(destWidth, destHeight, BufferedImage.TYPE_INT_RGB);
						Graphics g = tag.getGraphics();
						g.drawImage(img, 0, 0, null); // 绘制缩小后的图
						g.dispose();
						// 输出为文件
						ImageIO.write(tag, "JPEG", new File(descDir + "_r" + i + "_c" + j + ".jpg"));
					}
				}
			}
		} catch (Exception e) {
			log.error("", e);
		}
	}

	/**
	 * 图像切割（指定切片的宽度和高度）
	 * 
	 * @param srcImageFile
	 *            源图像地址
	 * @param descDir
	 *            切片目标文件夹
	 * @param destWidth
	 *            目标切片宽度。默认200
	 * @param destHeight
	 *            目标切片高度。默认150
	 */
	public final static void cut3(String srcImageFile, String descDir, int destWidth, int destHeight) {
		try {
			if (destWidth <= 0)
				destWidth = 200; // 切片宽度
			if (destHeight <= 0)
				destHeight = 150; // 切片高度
			// 读取源图像
			BufferedImage bi = ImageIO.read(new File(srcImageFile));
			int srcWidth = bi.getHeight(); // 源图宽度
			int srcHeight = bi.getWidth(); // 源图高度
			if (srcWidth > destWidth && srcHeight > destHeight) {
				Image img;
				ImageFilter cropFilter;
				Image image = bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);
				int cols = 0; // 切片横向数量
				int rows = 0; // 切片纵向数量
				// 计算切片的横向和纵向数量
				if (srcWidth % destWidth == 0) {
					cols = srcWidth / destWidth;
				} else {
					cols = (int) Math.floor(srcWidth / destWidth) + 1;
				}
				if (srcHeight % destHeight == 0) {
					rows = srcHeight / destHeight;
				} else {
					rows = (int) Math.floor(srcHeight / destHeight) + 1;
				}
				// 循环建立切片
				// 改进的想法:是否可用多线程加快切割速度
				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < cols; j++) {
						// 四个参数分别为图像起点坐标和宽高
						// 即: CropImageFilter(int x,int y,int width,int height)
						cropFilter = new CropImageFilter(j * destWidth, i * destHeight, destWidth, destHeight);
						img = Toolkit.getDefaultToolkit()
								.createImage(new FilteredImageSource(image.getSource(), cropFilter));
						BufferedImage tag = new BufferedImage(destWidth, destHeight, BufferedImage.TYPE_INT_RGB);
						Graphics g = tag.getGraphics();
						g.drawImage(img, 0, 0, null); // 绘制缩小后的图
						g.dispose();
						// 输出为文件
						ImageIO.write(tag, "JPEG", new File(descDir + "_r" + i + "_c" + j + ".jpg"));
					}
				}
			}
		} catch (Exception e) {
			log.error("", e);
		}
	}

	/**
	 * 图像类型转换：GIF->JPG、GIF->PNG、PNG->JPG、PNG->GIF(X)、BMP->PNG
	 * 
	 * @param srcImageFile
	 *            源图像地址
	 * @param formatName
	 *            包含格式非正式名称的 String：如JPG、JPEG、GIF等
	 * @param destImageFile
	 *            目标图像地址
	 */
	public final static void convert(String srcImageFile, String formatName, String destImageFile) {
		try {
			File f = new File(srcImageFile);
			f.canRead();
			f.canWrite();
			BufferedImage src = ImageIO.read(f);
			ImageIO.write(src, formatName, new File(destImageFile));
		} catch (Exception e) {
			log.error("", e);
		}
	}

	/**
	 * 彩色转为黑白
	 * 
	 * @param srcImageFile
	 *            源图像地址
	 * @param destImageFile
	 *            目标图像地址
	 */
	public final static void gray(String srcImageFile, String destImageFile) {
		try {
			BufferedImage src = ImageIO.read(new File(srcImageFile));
			ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
			ColorConvertOp op = new ColorConvertOp(cs, null);
			src = op.filter(src, null);
			ImageIO.write(src, "JPEG", new File(destImageFile));
		} catch (IOException e) {
			log.error("", e);
		}
	}

	/**
	 * 给图片添加文字水印
	 * 
	 * @param pressText
	 *            水印文字
	 * @param srcImageFile
	 *            源图像地址
	 * @param destImageFile
	 *            目标图像地址
	 * @param fontName
	 *            水印的字体名称
	 * @param fontStyle
	 *            水印的字体样式
	 * @param color
	 *            水印的字体颜色
	 * @param fontSize
	 *            水印的字体大小
	 * @param x
	 *            修正值
	 * @param y
	 *            修正值
	 * @param alpha
	 *            透明度：alpha 必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字
	 */
	public final static void pressText(String pressText, String srcImageFile, String destImageFile, String fontName,
			int fontStyle, Color color, int fontSize, int x, int y, float alpha) {
		try {
			File img = new File(srcImageFile);
			Image src = ImageIO.read(img);
			int width = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = image.createGraphics();
			g.drawImage(src, 0, 0, width, height, null);
			g.setColor(color);
			g.setFont(new Font(fontName, fontStyle, fontSize));
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
			// 在指定坐标绘制水印文字
			g.drawString(pressText, (width - (getLength(pressText) * fontSize)) / 2 + x, (height - fontSize) / 2 + y);
			g.dispose();
			ImageIO.write((BufferedImage) image, "JPEG", new File(destImageFile));// 输出到文件流
		} catch (Exception e) {
			log.error("", e);
		}
	}

	/**
	 * 给图片添加文字水印
	 * 
	 * @param pressText
	 *            水印文字
	 * @param srcImageFile
	 *            源图像地址
	 * @param destImageFile
	 *            目标图像地址
	 * @param fontName
	 *            字体名称
	 * @param fontStyle
	 *            字体样式
	 * @param color
	 *            字体颜色
	 * @param fontSize
	 *            字体大小
	 * @param x
	 *            修正值
	 * @param y
	 *            修正值
	 * @param alpha
	 *            透明度：alpha 必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字
	 */
	public final static void pressText2(String pressText, String srcImageFile, String destImageFile, String fontName,
			int fontStyle, Color color, int fontSize, int x, int y, float alpha) {
		try {
			File img = new File(srcImageFile);
			Image src = ImageIO.read(img);
			int width = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = image.createGraphics();
			g.drawImage(src, 0, 0, width, height, null);
			g.setColor(color);
			g.setFont(new Font(fontName, fontStyle, fontSize));
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
			// 在指定坐标绘制水印文字
			g.drawString(pressText, (width - (getLength(pressText) * fontSize)) / 2 + x, (height - fontSize) / 2 + y);
			g.dispose();
			ImageIO.write((BufferedImage) image, "JPEG", new File(destImageFile));
		} catch (Exception e) {
			log.error("", e);
		}
	}

	/**
	 * 给图片添加图片水印
	 * 
	 * @param pressImg
	 *            水印图片
	 * @param srcImageFile
	 *            源图像地址
	 * @param destImageFile
	 *            目标图像地址
	 * @param x
	 *            修正值。 默认在中间
	 * @param y
	 *            修正值。 默认在中间
	 * @param alpha
	 *            透明度：alpha 必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字
	 */
	public final static void pressImage(String pressImg, String srcImageFile, String destImageFile, int x, int y,
			float alpha) {
		try {
			File img = new File(srcImageFile);
			Image src = ImageIO.read(img);
			int wideth = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage image = new BufferedImage(wideth, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = image.createGraphics();
			g.drawImage(src, 0, 0, wideth, height, null);
			// 水印文件
			Image src_biao = ImageIO.read(new File(pressImg));
			int wideth_biao = src_biao.getWidth(null);
			int height_biao = src_biao.getHeight(null);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
			g.drawImage(src_biao, (wideth - wideth_biao) / 2, (height - height_biao) / 2, wideth_biao, height_biao,
					null);
			// 水印文件结束
			g.dispose();
			ImageIO.write((BufferedImage) image, "JPEG", new File(destImageFile));
		} catch (Exception e) {
			log.error("", e);
		}
	}

	/**
	 * 计算text的长度（一个中文算两个字符）
	 * 
	 * @param text
	 * @return
	 */
	public final static int getLength(String text) {
		int length = 0;
		for (int i = 0; i < text.length(); i++) {
			if (new String(text.charAt(i) + "").getBytes().length > 1) {
				length += 2;
			} else {
				length += 1;
			}
		}
		return length / 2;
	}

	/**
	 * 将多张png图片合并成一张png图片，并保持图片透明 imageList中，后添加的图片会覆盖和先添加图片重叠的部分
	 * 
	 * @param imageList
	 *            图片的本地路径列表
	 * @param outputFileName
	 */
	public static void appendByPath(List<String> imageList, String outputFileName) {
		if (imageList == null || imageList.size() == 0) {
			return;
		}
		try {
			boolean isFirstPng = true;
			BufferedImage outputImg = null;
			int width = 0;
			int height = 0;
			for (String pngFileName : imageList) {
				if (isFirstPng) {
					isFirstPng = false;
					outputImg = ImageIO.read(new File(pngFileName));
					width = outputImg.getWidth();
					height = outputImg.getHeight();
				} else {
					BufferedImage appendImg = ImageIO.read(new File(pngFileName));

					// create basic image
					Graphics2D g2d = outputImg.createGraphics();
					// 设置背景保持透明
					BufferedImage imageNew = g2d.getDeviceConfiguration().createCompatibleImage(width, height,
							Transparency.TRANSLUCENT);
					g2d.dispose();
					g2d = imageNew.createGraphics();
					// 绘制底图
					g2d.drawImage(outputImg, 0, 0, width, height, null);
					// 绘制新图
					g2d.drawImage(appendImg, 0, 0, width, height, null);

					g2d.dispose();
					outputImg = imageNew;
				}
			}
			writeImageLocal(outputFileName, outputImg);
		} catch (Exception e) {
			log.error("", e);
		}
	}

	/**
	 * 将多张png图片合并成一张png图片，并保持图片透明 imageList中，后添加的图片会覆盖和先添加图片重叠的部分
	 * 
	 * @param imageList
	 *            缓存图片列表
	 * @param outputFileName
	 */
	public static void appendByImageFile(List<BufferedImage> imageList, String outputFileName) {
		if (imageList == null || imageList.size() == 0) {
			return;
		}
		try {
			boolean isFirstPng = true;
			BufferedImage outputImg = null;
			int width = 0;
			int height = 0;
			for (BufferedImage img : imageList) {
				if (isFirstPng) {
					isFirstPng = false;
					outputImg = img;
					width = outputImg.getWidth();
					height = outputImg.getHeight();
				} else {
					BufferedImage appendImg = img;

					// create basic image
					Graphics2D g2d = outputImg.createGraphics();
					// 设置背景保持透明
					BufferedImage imageNew = g2d.getDeviceConfiguration().createCompatibleImage(width, height,
							Transparency.TRANSLUCENT);
					g2d.dispose();
					g2d = imageNew.createGraphics();
					// 绘制底图
					g2d.drawImage(outputImg, 0, 0, width, height, null);
					// 绘制新图
					g2d.drawImage(appendImg, 0, 0, width, height, null);

					g2d.dispose();
					outputImg = imageNew;
				}
			}
			writeImageLocal(outputFileName, outputImg);
		} catch (Exception e) {
			log.error("", e);
		}
	}

	/**
	 * 将合并的png图片写入
	 * 
	 * @param fileName
	 * @param image
	 */
	private static void writeImageLocal(String fileName, BufferedImage image) {
		if (fileName != null && image != null) {
			try {
				File file = new File(fileName);
				ImageIO.write(image, "png", file);
			} catch (IOException e) {
				log.error("", e);
			}
		}
	}

	/**
	 * 根据给出的url地址下载图片，如果下载成功，则保持改图片在指定目录
	 * 
	 * @param imageUrl
	 * @param dir
	 *            指定目录
	 * @return
	 */
	public static String downloadImage(String imageUrl, String dir) {
		String imageFilePath = null;
		InputStream inStream = null;
		FileOutputStream outStream = null;
		try {
			String fileName = StringUtils.substringAfterLast(imageUrl, "/");
			URL url = new URL(imageUrl);
			// 打开链接
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 设置请求方式为"GET"
			conn.setRequestMethod("GET");
			// 超时响应时间为5秒
			conn.setConnectTimeout(5 * 1000);
			// 通过输入流获取图片数据
			inStream = conn.getInputStream();
			// 得到图片的二进制数据，以二进制封装得到数据，具有通用性
			byte[] data = readInputStream(inStream);
			// new一个文件对象用来保存图片，默认保存当前工程根目录
			File imageFile = new File(dir + fileName);
			// 创建输出流
			outStream = new FileOutputStream(imageFile);
			// 写入数据
			outStream.write(data);
			// 下载成功
			imageFilePath = dir + fileName;
		} catch (Exception e) {
			System.out.println("下载图片异常，url[" + imageUrl + "]");
		} finally {
			// 关闭输入输出流
			IoUtil.close(inStream, outStream);
		}
		return imageFilePath;
	}

	private static byte[] readInputStream(InputStream inStream) throws Exception {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		// 创建一个Buffer字符串
		byte[] buffer = new byte[1024];
		// 每次读取的字符串长度，如果为-1，代表全部读取完毕
		int len = 0;
		// 使用一个输入流从buffer里把数据读取出来
		while ((len = inStream.read(buffer)) != -1) {
			// 用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
			outStream.write(buffer, 0, len);
		}
		// 关闭输入流
		inStream.close();
		// 把outStream里的数据写入内存
		return outStream.toByteArray();
	}

	/**
	 * @Title: getImageSquare
	 * @Description: 获取指定图片，尺寸指定，本方法特点是即使很大的图片也不用全部下载下来再做尺寸缩放<br>
	 *               如果下载的图片不是正方形，会自动上下或者左右补透明
	 * @param imageUrl
	 * @param size
	 * @return: BufferedImage
	 * @throws:
	 */
	public static BufferedImage getImageSquare(String imageUrl, int size) {
		BufferedImage image = null;
		try {
			image = getImage(imageUrl, size);
			// 判断logo的尺寸和设定的尺寸是否一致，如果不一致则进行校正，以及短边居中补白
			if (image.getWidth() != size || image.getHeight() != size) {
				image = ImageUtil.scaleToSquare(image, size);
			}
		} catch (Exception e) {
			log.error("获取图片异常[{}]", imageUrl);
		}
		return image;
	}

	/**
	 * @Title: getImage
	 * @Description: 获取指定图片，尺寸指定，本方法特点是即使很大的图片也不用全部下载下来再做尺寸缩放<br>
	 *               指定宽，高度会等比例缩放
	 * @param imageUrl
	 * @param size
	 * @return: BufferedImage
	 * @throws:
	 */
	public static BufferedImage getImage(String imageUrl, int size) {
		BufferedImage image = null;
		HttpURLConnection conn = null;
		InputStream in = null;
		ImageInputStream iis = null;
		try {
			// 尝试获取logo
			URL url = new URL(imageUrl);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(3 * 1000);
			in = conn.getInputStream();// 通过输入流获取图片数据

			iis = ImageIO.createImageInputStream(in);
			ImageReader reader = ImageIO.getImageReaders(iis).next();
			reader.setInput(iis);
			ImageReadParam param = reader.getDefaultReadParam();
			// 获取图片的原始尺寸，注意，这里采用ImageReader的好处是不需要把整个图片加载到内存就能知道该图片尺寸
			int width = reader.getWidth(0);
			int height = reader.getHeight(0);
			// 找出最长边
			int maxSize = Math.max(width, height);
			// 根据最长边计算采样间隔
			int space = maxSize / size;
			param.setSourceSubsampling(space, space, 0, 0);
			image = reader.read(0, param);
		} catch (Exception e) {
			log.error("获取图片异常[{}]", imageUrl);
			image = null;
		} finally {
			IoUtil.close(iis, in);
			try {
				if (conn != null) {
					conn.disconnect();
				}
			} catch (Exception e2) {
				log.error("", e2);
			}
		}
		return image;
	}

	// @Deprecated
	// public static void main(String[] args) {
	// // combineImages(null);
	// String file1 = "./image/lan1.png";
	// String file2 = "./image/lan2.png";
	// String file3 = "./image/lan3.png";
	// String out = "./image/combine.png";
	// // composePic(file1, file2, file3, 0, 0);
	//
	// List<String> list = new ArrayList<String>();
	// list.add(file1);
	// list.add(file2);
	// list.add(file3);
	//
	// appendByPath(list, out);
	//
	// // 1-缩放图像：
	// // 方法一：按比例缩放
	// ImageUtil.scale("e:/abc.jpg", "e:/abc_scale.jpg", 2);// 测试OK
	//
	// // 2-切割图像：
	// // 方法一：按指定起点坐标和宽高切割
	// ImageUtil.cut("e:/abc.jpg", "e:/abc_cut.jpg", 0, 0, 400, 400);// 测试OK
	// // 方法二：指定切片的行数和列数
	// ImageUtil.cut2("e:/abc.jpg", "e:/", 2, 2);// 测试OK
	// // 方法三：指定切片的宽度和高度
	// ImageUtil.cut3("e:/abc.jpg", "e:/", 300, 300);// 测试OK
	//
	// // 3-图像类型转换：
	// ImageUtil.convert("e:/abc.jpg", "GIF", "e:/abc_convert.gif");// 测试OK
	//
	// // 4-彩色转黑白：
	// ImageUtil.gray("e:/abc.jpg", "e:/abc_gray.jpg");// 测试OK
	//
	// // 5-给图片添加文字水印：
	// // 方法一：
	// ImageUtil.pressText("我是水印文字", "e:/abc.jpg", "e:/abc_pressText.jpg", "宋体",
	// Font.BOLD, Color.white, 80, 0, 0,
	// 0.5f);// 测试OK
	// // 方法二：
	// ImageUtil.pressText2("我也是水印文字", "e:/abc.jpg", "e:/abc_pressText2.jpg",
	// "黑体", 36, Color.white, 80, 0, 0, 0.5f);// 测试OK
	//
	// // 6-给图片添加图片水印：
	// ImageUtil.pressImage("e:/abc2.jpg", "e:/abc.jpg",
	// "e:/abc_pressImage.jpg", 0, 0, 0.5f);// 测试OK
	// }

}
