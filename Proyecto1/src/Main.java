
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * 
 * @author Juan Marroquin
 */
public class Main extends javax.swing.JFrame {

    private final JFileChooser openFile;
    private BufferedReader lector;
    public Main() {
        initComponents();
        openFile = new JFileChooser();
        openFile.setCurrentDirectory(new File("c:\\temp"));
        openFile.setFileFilter(new FileNameExtensionFilter("Txt files","txt"));
    }

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        botonBuscar = new javax.swing.JButton();
        labelNombreArchivo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonBuscar.setText("Open File...");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        labelNombreArchivo.setBackground(new java.awt.Color(255, 255, 255));
        labelNombreArchivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNombreArchivo.setText("choose file");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Bienvenidos al Interpretador de LISP");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonBuscar)
                .addGap(18, 18, 18)
                .addComponent(labelNombreArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonBuscar)
                    .addComponent(labelNombreArchivo))
                .addContainerGap(230, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        int returnValue = openFile.showOpenDialog(this);
        
        if (returnValue==JFileChooser.APPROVE_OPTION){
            try{
                //lector = FileReader.read(openFile.getSelectedFile());
                lector = new BufferedReader(new FileReader(openFile.getSelectedFile()));
                labelNombreArchivo.setText(openFile.getName());
                labelNombreArchivo.setText("si funciona");
            }catch(IOException io){
                labelNombreArchivo.setText("Fallo la carga del archivo");
            }
        }else{
            labelNombreArchivo.setText("No se escogio ningun archivo");
        }
        
    }//GEN-LAST:event_botonBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelNombreArchivo;
    // End of variables declaration//GEN-END:variables
}
