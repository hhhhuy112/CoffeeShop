/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import bean.HoaDon;
import bean.NhanVien;
import com.itextpdf.text.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controller.ControllerNhanVien;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author Hi
 */
public class LibraryPhieuHang {

    private static String fileName;
    private static BaseFont timesNewRoman;
    private static Font f15b, f10b, f10, f10i, f12b;
    private Vector<String> vCols;
    private Vector vRows;

    public LibraryPhieuHang(Vector<String> vCols, Vector vRows, String path) {
        this.vCols = vCols;
        this.vRows = vRows;
        fileName = path;
    }

    public static String getFileName() {
        return fileName;
    }

    public static void setFileName(String fileName) {
        LibraryPhieuHang.fileName = fileName;
    }

    public static BaseFont getTimesNewRoman() {
        return timesNewRoman;
    }

    public static void setTimesNewRoman(BaseFont timesNewRoman) {
        LibraryPhieuHang.timesNewRoman = timesNewRoman;
    }

    public static Font getF15b() {
        return f15b;
    }

    public static void setF15b(Font f15b) {
        LibraryPhieuHang.f15b = f15b;
    }

    public static Font getF10b() {
        return f10b;
    }

    public static void setF10b(Font f10b) {
        LibraryPhieuHang.f10b = f10b;
    }

    public static Font getF10() {
        return f10;
    }

    public static void setF10(Font f10) {
        LibraryPhieuHang.f10 = f10;
    }

    public static Font getF10i() {
        return f10i;
    }

    public static void setF10i(Font f10i) {
        LibraryPhieuHang.f10i = f10i;
    }

    public static Font getF12b() {
        return f12b;
    }

    public static void setF12b(Font f12b) {
        LibraryPhieuHang.f12b = f12b;
    }

    public Vector<String> getvCols() {
        return vCols;
    }

    public void setvCols(Vector<String> vCols) {
        this.vCols = vCols;
    }

    public Vector getvRows() {
        return vRows;
    }

    public void setvRows(Vector vRows) {
        this.vRows = vRows;
    }

    public int create(Document document,Date dateTO,Date dateFROM) {
        int i = 1;
        String fontPath = "font\\times.ttf";
        try {
            createFonts(fontPath);
        } catch (DocumentException e) {
            i = 0;
            e.printStackTrace();
        } catch (IOException e) {
            i = 0;
            e.printStackTrace();
        }
        //DocumentException(PageSize.A4, 10, 10, 10, 10);
        try {
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
        } catch (Exception e) {
            i = 0;
            e.printStackTrace();
        }

        document.open();
        document.newPage();

        addMetaData(document);
        addHeader(document,dateTO,dateFROM);
        createTable(document);

        document.close();
        System.out.println("Done");
        return i;
    }

    private static void createFonts(String fontPath) throws DocumentException, IOException {

        timesNewRoman = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, false);

        f15b = new Font(timesNewRoman, 15, Font.BOLD);
        f10b = new Font(timesNewRoman, 10, Font.BOLD);
        f10 = new Font(timesNewRoman, 10, Font.NORMAL);
        f10i = new Font(timesNewRoman, 10, Font.ITALIC);
        f12b = new Font(timesNewRoman, 12, Font.BOLD);

    }

    private static void addMetaData(Document document) {
        document.addTitle("Biên lai hàng hóa");
        document.addSubject("Coffee Arsenal");
        document.addKeywords("Bienlai");
        document.addAuthor("minhhuyho");
        document.addCreator("minhhuyho");
    }

    private static void addHeader(Document document,Date dateTO,Date dateFROM) {
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        String dateT=sdf.format(dateTO);
        String dateF=sdf.format(dateFROM);
        PdfPTable headTable = new PdfPTable(2);

        try {
            headTable.setWidths(new int[]{4, 6});
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        PdfPCell cell = null;

        cell = new PdfPCell(new Phrase("BIÊN LAI THU TIỀN", f10b));
        cell.setHorizontalAlignment(Rectangle.ALIGN_CENTER);
        cell.setBorder(Rectangle.NO_BORDER);
        headTable.addCell(cell);

        cell = new PdfPCell(new Phrase("COFFEE ARSENAL", f10b));
        cell.setHorizontalAlignment(Rectangle.ALIGN_CENTER);
        cell.setBorder(Rectangle.NO_BORDER);
        headTable.addCell(cell);

        Chunk line = new Chunk("____________________", f10);
        line.setTextRise(12);
        cell = new PdfPCell(new Phrase(line));
        cell.setHorizontalAlignment(Rectangle.ALIGN_CENTER);
        cell.setBorder(Rectangle.NO_BORDER);
        headTable.addCell(cell);

        headTable.addCell(cell);

        cell = new PdfPCell(new Phrase("Thống kê thu nhập", f12b));
        cell.setHorizontalAlignment(Rectangle.ALIGN_CENTER);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setColspan(2);
        cell.setPadding(10);
        headTable.addCell(cell);

        cell = new PdfPCell(new Phrase("Từ ngày: "+dateT, f10));
        cell.setHorizontalAlignment(Rectangle.ALIGN_CENTER);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setColspan(2);
        headTable.addCell(cell);

        cell = new PdfPCell(new Phrase("Đến ngày:"+dateF, f10));
        cell.setHorizontalAlignment(Rectangle.ALIGN_CENTER);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setColspan(2);
        cell.setPaddingBottom(10);
        headTable.addCell(cell);

        try {
            document.add(headTable);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

    private void createTable(Document document) {

        PdfPTable table = new PdfPTable(6);
        // set size for the table
        try {
            table.setWidths(new int[]{6, 1, 1, 1});
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        PdfPCell cell = null;

        cell = new PdfPCell(new Phrase("Bản thống kê thu nhập", f15b));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        cell.setColspan(7);
        table.addCell(cell);
        for (int i = 0; i < this.getvCols().size(); i++) {
            cell = new PdfPCell(new Phrase(this.vCols.get(i), f10));
            cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            cell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
            table.addCell(cell);

        }
        double tongTien=0;
        for (int j = 0; j < vRows.size(); j++) {
            Vector vR = ((Vector) vRows.get(j));
            for (int k = 0; k < vR.size(); k++) {
                if(k==vR.size()-1){
                    tongTien+=Double.parseDouble(vR.get(k).toString());
                }
                
                cell = new PdfPCell(new Phrase(String.valueOf(vR.get(k)), f10));
                cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                cell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
                table.addCell(cell);
            }
        }
        cell = new PdfPCell(new Phrase("Tổng tiền", f15b));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        cell.setColspan(5);
        table.addCell(cell);
         cell = new PdfPCell(new Phrase(String.valueOf(tongTien), f15b));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        table.addCell(cell);
        
        //-------------
        try {
            document.add(table);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }
}
