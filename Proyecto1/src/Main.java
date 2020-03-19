
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Main extends javax.swing.JFrame {
    Lexer lex;
    String codigo;
    ArrayList<String>datos = new ArrayList<>();
    public String lineas ;
    private final JFileChooser openFile;
    private BufferedReader lector;
    String FileName;
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
        botonEjecutar = new javax.swing.JButton();

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
        labelNombreArchivo.setText("......");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Bienvenidos al Interpretador de LISP");

        botonEjecutar.setText("Ejecutar");
        botonEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEjecutarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2)
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(botonEjecutar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(labelNombreArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addGap(46, 46, 46)
                .addComponent(botonEjecutar)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        int returnValue = openFile.showOpenDialog(this);
        
        if (returnValue==JFileChooser.APPROVE_OPTION){
            try{
                //lector = FileReader.read(openFile.getSelectedFile());
                lector = new BufferedReader(new FileReader(openFile.getSelectedFile()));
                FileName = openFile.getName(openFile.getSelectedFile());
                //labelNombreArchivo.setText(FileName);
                labelNombreArchivo.setText("si funciona");
                while(lector.ready()){
                    lineas = lector.readLine();
                    datos.add(lineas);
                }
                codigo = datos.toString();
              
            }catch(IOException io){
                labelNombreArchivo.setText("Fallo la carga del archivo");
            }
        }else{
            labelNombreArchivo.setText("No se escogio ningun archivo");
        }
        for (String c:datos){
            System.out.println(c);  
        }
        
        //System.out.println(datos);
        /*ArrayList<Token> tokens = lex.lex(lineas);
        for(Token token:tokens) {
         System.out.println(token);
        }*/
        
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEjecutarActionPerformed
        String variable = Lexer.Variables(codigo);
        ArrayList<Lexer.Token> tokens = Lexer.lex(variable);
		for(Lexer.Token token:tokens) {
			System.out.println(token);
		}
        
    }//GEN-LAST:event_botonEjecutarActionPerformed

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
    private javax.swing.JButton botonEjecutar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelNombreArchivo;
    // End of variables declaration//GEN-END:variables
 
    
}
