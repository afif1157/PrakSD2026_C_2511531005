package pekan9_2511531005;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class PetaPadang_2511531005 extends JFrame implements ActionListener {

    private List<String> vertices_1005;
    private Map<String, List<String>> adjList_1005;
    private Map<String, Point> nodePosition_1005;
    
    private JComboBox<String> startCombo_1005;
    private JComboBox<String> goalCombo_1005;
    private JButton btnBFS_1005;
    private JButton btnDFS_1005;
    private JButton btnReset_1005;
    private JTextArea resultArea_1005;
    private GraphPanel_1005 canvas_1005;
    
    private List<String> visitedNodes_1005;
    private List<String> pathNodes_1005;
    private int exploredCount_1005;
    private String lastMethod_1005;
    private String lastStart_1005;
    private String lastGoal_1005;
    
    public PetaPadang_2511531005() {
        setTitle("PENCARIAN JALUR MENGGUNAKAN BFS DAN DFS");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        
        initializeGraph_1005();
        
        visitedNodes_1005 = new ArrayList<>();
        pathNodes_1005 = new ArrayList<>();
        exploredCount_1005 = 0;
        lastMethod_1005 = "";
        lastStart_1005 = "";
        lastGoal_1005 = "";
        
        setupGUI_1005();
    }
    
    //inisialisasi graf
    public void initializeGraph_1005() {
        vertices_1005 = new ArrayList<>();
        adjList_1005 = new HashMap<>();
        nodePosition_1005 = new HashMap<>();
        
        String[] locations_1005 = {
                "Lubuk Buayo", "Unand", "Spendu", "Katib", 
                "Jati", "Pondok", "Taplau", "Basko", "Gacoan bypass",
                "Kopkit sutomo"
        };
        
        for(String loc_1005 : locations_1005) {
            vertices_1005.add(loc_1005);
            adjList_1005.put(loc_1005, new ArrayList<>());
        }
        
        // Koordinat Node (X, Y)
        nodePosition_1005.put("Unand", new Point(500, 20));
        nodePosition_1005.put("Lubuk Buayo", new Point(200, 120));
        nodePosition_1005.put("Spendu", new Point(800, 120));
        nodePosition_1005.put("Katib", new Point(200, 220));
        nodePosition_1005.put("Jati", new Point(500, 220));
        nodePosition_1005.put("Pondok", new Point(800, 220));
        nodePosition_1005.put("Taplau", new Point(500, 320));
        nodePosition_1005.put("Basko", new Point(200, 420));
        nodePosition_1005.put("Gacoan bypass", new Point(500, 420));
        nodePosition_1005.put("Kopkit sutomo", new Point(800, 420));
        
        // 15 Edge Penghubung
        addEdge_1005("Lubuk Buayo", "Unand");
        addEdge_1005("Lubuk Buayo", "Spendu");
        addEdge_1005("Unand", "Spendu");
        addEdge_1005("Pondok", "Spendu");
        addEdge_1005("Lubuk Buayo", "Jati");
        addEdge_1005("Lubuk Buayo", "Katib");
        addEdge_1005("Gacoan bypass", "Jati");
        addEdge_1005("Jati", "Pondok");
        addEdge_1005("Pondok", "Kopkit sutomo");       
        addEdge_1005("Jati", "Kopkit sutomo");        
        addEdge_1005("Kopkit sutomo", "Basko");        
        addEdge_1005("Basko", "Taplau");
        addEdge_1005("Basko", "Katib");
        addEdge_1005("Taplau", "Katib");
        addEdge_1005("Jati", "Taplau");
    }
    
    private void addEdge_1005(String u_1005, String v_1005) {
        adjList_1005.get(u_1005).add(v_1005);
        adjList_1005.get(v_1005).add(u_1005);
    }
    
    //setup gui
    public void setupGUI_1005() {
        // Panel Kontrol Atas
        JPanel controlPanel_1005 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 15));
        controlPanel_1005.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            "Pencarian Jalur Menggunakan BFS dan DFS",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 14)
        ));
        
        // Lokasi Awal
        JLabel lblStart_1005 = new JLabel("Lokasi Awal : ");
        lblStart_1005.setFont(new Font("Arial", Font.PLAIN, 14));
        controlPanel_1005.add(lblStart_1005);
        
        startCombo_1005 = new JComboBox<>(vertices_1005.toArray(new String[0]));
        startCombo_1005.setFont(new Font("Arial", Font.PLAIN, 14));
        controlPanel_1005.add(startCombo_1005);
        
        // Lokasi Tujuan 
        JLabel lblGoal_1005 = new JLabel("Lokasi Tujuan : "); 
        lblGoal_1005.setFont(new Font("Arial", Font.PLAIN, 14));
        controlPanel_1005.add(lblGoal_1005);
        
        goalCombo_1005 = new JComboBox<>(vertices_1005.toArray(new String[0]));
        goalCombo_1005.setFont(new Font("Arial", Font.PLAIN, 14));
        goalCombo_1005.setSelectedIndex(9); 
        controlPanel_1005.add(goalCombo_1005); 
        
        // Tombol BFS, DFS, RESET
        btnBFS_1005 = new JButton("BFS");
        btnBFS_1005.setBackground(new Color(144, 238, 144));
        btnBFS_1005.setFont(new Font("Arial", Font.BOLD, 14));
        btnBFS_1005.setPreferredSize(new Dimension(90, 35));
        
        btnDFS_1005 = new JButton("DFS");
        btnDFS_1005.setBackground(new Color(255, 200, 120));
        btnDFS_1005.setFont(new Font("Arial", Font.BOLD, 14));
        btnDFS_1005.setPreferredSize(new Dimension(90, 35));
        
        btnReset_1005 = new JButton("Reset");
        btnReset_1005.setBackground(new Color(255, 130, 130));
        btnReset_1005.setFont(new Font("Arial", Font.BOLD, 14));
        btnReset_1005.setPreferredSize(new Dimension(90, 35));
        
        btnBFS_1005.addActionListener(this);
        btnDFS_1005.addActionListener(this);
        btnReset_1005.addActionListener(this);
        
        controlPanel_1005.add(btnBFS_1005);
        controlPanel_1005.add(btnDFS_1005);
        controlPanel_1005.add(btnReset_1005);
        
        add(controlPanel_1005, BorderLayout.NORTH);
        
        // Panel Tengah (Visualisasi Graph)
        JPanel graphContainer_1005 = new JPanel(new BorderLayout());
        graphContainer_1005.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            "Visualisasi Graph",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 14)
        ));
        canvas_1005 = new GraphPanel_1005();
        graphContainer_1005.add(canvas_1005, BorderLayout.CENTER);
        
        add(graphContainer_1005, BorderLayout.CENTER);

        // Panel Bawah (Hasil Pencarian)
        JPanel resultPanel_1005 = new JPanel(new BorderLayout());
        resultPanel_1005.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            "Hasil Pencarian",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 14)
        ));
        
        resultArea_1005 = new JTextArea(8, 50);
        resultArea_1005.setEditable(false);
        resultArea_1005.setFont(new Font("Monospaced", Font.PLAIN, 13));
        resultArea_1005.setText(buildEmptyResult_1005());
        
        JScrollPane scrollPane_1005 = new JScrollPane(resultArea_1005);
        resultPanel_1005.add(scrollPane_1005, BorderLayout.CENTER);
        
        add(resultPanel_1005, BorderLayout.SOUTH);
    }

    private String buildEmptyResult_1005() {
        return "Algoritma\t\t: -\n" +
               "Lokasi Awal\t\t: -\n" +
               "Lokasi Tujuan\t\t: -\n" +
               "------------------------------------------------------------\n" +
               "Node Dikunjungi\t: -\n" +
               "Jumlah Dieksplorasi\t: 0 node\n" +
               "------------------------------------------------------------\n" +
               "Jalur\t\t\t: Belum ada pencarian";
    }
   
    //algoritma  bfs
    public void BFS_1005(String start_1005, String goal_1005) {
        resetGraph_1005();
        
        Queue<String> queue_1005 = new LinkedList<>();
        Set<String> visitedSet_1005 = new LinkedHashSet<>();
        Map<String, String> parent_1005 = new HashMap<>();
        
        queue_1005.add(start_1005);
        visitedSet_1005.add(start_1005);
        
        boolean found_1005 = false;
        
        while(!queue_1005.isEmpty()) {
            String current_1005 = queue_1005.poll();
            visitedNodes_1005.add(current_1005);
            exploredCount_1005++;
            
            if(current_1005.equals(goal_1005)) {
                found_1005 = true;
                break;
            }
            
            List<String> neighbors_1005 = new ArrayList<>(adjList_1005.get(current_1005));
            Collections.sort(neighbors_1005);
            
            for(String neighbor_1005 : neighbors_1005) {
                if(!visitedSet_1005.contains(neighbor_1005)) {
                    visitedSet_1005.add(neighbor_1005);
                    parent_1005.put(neighbor_1005, current_1005);
                    queue_1005.add(neighbor_1005);
                }
            }
        }
        
        if(found_1005) {
            reconstructPath_1005(parent_1005, start_1005, goal_1005);
        }
        lastMethod_1005 = "BFS";
        lastStart_1005 = start_1005;
        lastGoal_1005 = goal_1005;
        displayPath_1005("BFS");
    }

    //algoritma dfs
    public void DFS_1005(String start_1005, String goal_1005) {
        resetGraph_1005(); 
        
        Stack<String> stack_1005 = new Stack<>();
        Set<String> visitedSet_1005 = new LinkedHashSet<>();
        Map<String, String> parent_1005 = new HashMap<>();
        
        stack_1005.push(start_1005);
        
        boolean found_1005 = false;
        
        while (!stack_1005.isEmpty()) {
            String current_1005 = stack_1005.pop();
            
            if (!visitedSet_1005.contains(current_1005)) {
                visitedSet_1005.add(current_1005);
                visitedNodes_1005.add(current_1005);
                exploredCount_1005++;
                
                if (current_1005.equals(goal_1005)) {
                    found_1005 = true;
                    break;
                }
                
                List<String> neighbors_1005 = new ArrayList<>(adjList_1005.get(current_1005));
                Collections.sort(neighbors_1005);
                Collections.reverse(neighbors_1005);
                
                for (String neighbor_1005 : neighbors_1005) {
                    if (!visitedSet_1005.contains(neighbor_1005)) {
                        parent_1005.put(neighbor_1005, current_1005);
                        stack_1005.push(neighbor_1005);
                    }
                }
            }
        }
        
        if (found_1005) {
            reconstructPath_1005(parent_1005, start_1005, goal_1005);
        }
        lastMethod_1005 = "DFS";
        lastStart_1005 = start_1005;
        lastGoal_1005 = goal_1005;
        displayPath_1005("DFS");
    }
    
    private void reconstructPath_1005(Map<String, String> parent_1005, String start_1005, String goal_1005) {
        List<String> path_1005 = new ArrayList<>();
        String current_1005 = goal_1005;
        
        while (current_1005 != null) {
            path_1005.add(current_1005);
            current_1005 = parent_1005.get(current_1005);
        }
        Collections.reverse(path_1005);
        pathNodes_1005 = path_1005;
    }
    
   //display
    public void displayGraph_1005(Graphics g_1005) {
        canvas_1005.repaint();
    }
    
    public void displayPath_1005(String method_1005) {
        StringBuilder sb_1005 = new StringBuilder();
        
        sb_1005.append("Algoritma\t\t: ").append(method_1005).append("\n");
        sb_1005.append("Lokasi Awal\t\t: ").append(getShortName_1005(lastStart_1005)).append("\n");
        sb_1005.append("Lokasi Tujuan\t\t: ").append(getShortName_1005(lastGoal_1005)).append("\n");
        sb_1005.append("------------------------------------------------------------\n");
        
        List<String> visitedShort_1005 = new ArrayList<>();
        for (String n_1005 : visitedNodes_1005) {
            visitedShort_1005.add(getShortName_1005(n_1005));
        }
        sb_1005.append("Node Dikunjungi\t: ").append(String.join(" -> ", visitedShort_1005)).append("\n");
        sb_1005.append("Jumlah Dieksplorasi\t: ").append(exploredCount_1005).append(" node\n");
        sb_1005.append("------------------------------------------------------------\n");
        
        if (pathNodes_1005.isEmpty()) {
            sb_1005.append("Jalur\t\t\t: Tidak ditemukan!");
        } else {
            List<String> pathShort_1005 = new ArrayList<>();
            for (String n_1005 : pathNodes_1005) {
                pathShort_1005.add(getShortName_1005(n_1005));
            }
            sb_1005.append("Jalur\t\t\t: ").append(String.join(" -> ", pathShort_1005));
        }
        
        resultArea_1005.setText(sb_1005.toString());
        displayGraph_1005(canvas_1005.getGraphics()); 
    }
    
    public void resetGraph_1005() {
        visitedNodes_1005.clear();
        pathNodes_1005.clear();
        exploredCount_1005 = 0;
        resultArea_1005.setText(buildEmptyResult_1005());
        canvas_1005.repaint();
    }
    
    private String getShortName_1005(String name_1005) {
        if (name_1005 == null) return "-";
        if (name_1005.contains("Unand")) return "Unand";
        if (name_1005.contains("Lubuk Buayo")) return "Lubuk Buayo";
        if (name_1005.contains("Spendu")) return "Spendu";
        if (name_1005.contains("Katib")) return "Katib";
        if (name_1005.contains("Jati")) return "Jati";
        if (name_1005.contains("Pondok")) return "Pondok";
        if (name_1005.contains("Taplau")) return "Taplau";
        if (name_1005.contains("Basko")) return "Basko";
        if (name_1005.contains("Gacoan bypass")) return "Gacoan Bypass"; 
        if (name_1005.contains("Kopkit sutomo")) return "Kopkit Sutomo";
        return name_1005;
    }

    @Override
    public void actionPerformed(ActionEvent e_1005) {
        String start_1005 = (String) startCombo_1005.getSelectedItem();
        String goal_1005 = (String) goalCombo_1005.getSelectedItem();
        
        if (e_1005.getSource() == btnReset_1005) {
            resetGraph_1005();
            return;
        }
        
        if (start_1005.equals(goal_1005)) {
            JOptionPane.showMessageDialog(this, "Lokasi awal dan tujuan tidak boleh sama!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (e_1005.getSource() == btnBFS_1005) {
            BFS_1005(start_1005, goal_1005);
        } else if (e_1005.getSource() == btnDFS_1005) {
            DFS_1005(start_1005, goal_1005);
        }
    }
    
 
    class GraphPanel_1005 extends JPanel {
        
        // Warna sesuai legenda
        private final Color COLOR_START_1005      = new Color(0, 230, 0);    // Hijau - Start Node
        private final Color COLOR_GOAL_1005       = new Color(230, 0, 0);    // Merah - Goal Node
        private final Color COLOR_PATH_EDGE_1005  = new Color(255, 200, 0);  // Kuning - Edge Jalur
        private final Color COLOR_VISITED_1005    = new Color(0, 220, 220);  // Cyan - Dikunjungi
        private final Color COLOR_UNVISITED_1005  = new Color(190, 190, 190);// Abu-abu - Belum dikunjungi
        private final Color COLOR_TEXT_DARK_1005  = Color.BLACK;
        private final Color COLOR_TEXT_LIGHT_1005 = Color.WHITE;
        
        private final int NODE_RADIUS_1005 = 40;
        
        @Override
        protected void paintComponent(Graphics g_1005) {
            super.paintComponent(g_1005);
            Graphics2D g2d_1005 = (Graphics2D) g_1005;
            g2d_1005.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            String startSel_1005 = (String) startCombo_1005.getSelectedItem();
            String goalSel_1005  = (String) goalCombo_1005.getSelectedItem();
            
            // 1. Gambar semua Edge (garis abu-abu tipis)
            g2d_1005.setColor(new Color(120, 120, 120));
            g2d_1005.setStroke(new BasicStroke(1.5f));
            Set<String> drawnEdges_1005 = new LinkedHashSet<>();
            for (String u_1005 : adjList_1005.keySet()) {
                Point p1_1005 = nodePosition_1005.get(u_1005);
                for (String v_1005 : adjList_1005.get(u_1005)) {
                    String key_1005 = u_1005.compareTo(v_1005) < 0 ? u_1005 + "|" + v_1005 : v_1005 + "|" + u_1005;
                    if (drawnEdges_1005.contains(key_1005)) continue;
                    drawnEdges_1005.add(key_1005);
                    Point p2_1005 = nodePosition_1005.get(v_1005);
                    g2d_1005.drawLine(p1_1005.x, p1_1005.y, p2_1005.x, p2_1005.y);
                }
            }
            
            // 2. Gambar Edge Jalur Terbaik (Garis Kuning Tebal)
            if (!pathNodes_1005.isEmpty()) {
                g2d_1005.setColor(COLOR_PATH_EDGE_1005);
                g2d_1005.setStroke(new BasicStroke(4));
                for (int i_1005 = 0; i_1005 < pathNodes_1005.size() - 1; i_1005++) {
                    String u_1005 = pathNodes_1005.get(i_1005);
                    String v_1005 = pathNodes_1005.get(i_1005 + 1);
                    Point p1_1005 = nodePosition_1005.get(u_1005);
                    Point p2_1005 = nodePosition_1005.get(v_1005);
                    g2d_1005.drawLine(p1_1005.x, p1_1005.y, p2_1005.x, p2_1005.y);
                }
            }
            
            // 3. Gambar Node (Lingkaran + Teks)
            for (String node_1005 : vertices_1005) {
                Point p_1005 = nodePosition_1005.get(node_1005);
                int x_1005 = p_1005.x;
                int y_1005 = p_1005.y;
                
                Color fillColor_1005;
                Color textColor_1005;
                
                if (node_1005.equals(startSel_1005)) {
                    fillColor_1005 = COLOR_START_1005;
                    textColor_1005 = COLOR_TEXT_DARK_1005;
                } else if (node_1005.equals(goalSel_1005)) {
                    fillColor_1005 = COLOR_GOAL_1005;
                    textColor_1005 = COLOR_TEXT_LIGHT_1005;
                } else if (visitedNodes_1005.contains(node_1005)) {
                    fillColor_1005 = COLOR_VISITED_1005;
                    textColor_1005 = COLOR_TEXT_DARK_1005;
                } else {
                    fillColor_1005 = COLOR_UNVISITED_1005;
                    textColor_1005 = COLOR_TEXT_DARK_1005;
                }
                
                // Lingkaran node
                g2d_1005.setColor(fillColor_1005);
                g2d_1005.fillOval(x_1005 - NODE_RADIUS_1005, y_1005 - NODE_RADIUS_1005, NODE_RADIUS_1005 * 2, NODE_RADIUS_1005 * 2);
                
                // Border lingkaran
                g2d_1005.setColor(Color.DARK_GRAY);
                g2d_1005.setStroke(new BasicStroke(1.5f));
                g2d_1005.drawOval(x_1005 - NODE_RADIUS_1005, y_1005 - NODE_RADIUS_1005, NODE_RADIUS_1005 * 2, NODE_RADIUS_1005 * 2);
                
                // Teks Node (bisa 2 baris jika nama panjang)
                g2d_1005.setColor(textColor_1005);
                g2d_1005.setFont(new Font("Arial", Font.BOLD, 12));
                FontMetrics fm_1005 = g2d_1005.getFontMetrics();
                String shortName_1005 = getShortName_1005(node_1005);
                
                String[] words_1005 = shortName_1005.split(" ");
                if (words_1005.length > 1) {
                    // Bagi jadi 2 baris
                    StringBuilder line1_1005 = new StringBuilder();
                    StringBuilder line2_1005 = new StringBuilder();
                    int mid_1005 = (words_1005.length + 1) / 2;
                    for (int i_1005 = 0; i_1005 < words_1005.length; i_1005++) {
                        if (i_1005 < mid_1005) {
                            if (line1_1005.length() > 0) line1_1005.append(" ");
                            line1_1005.append(words_1005[i_1005]);
                        } else {
                            if (line2_1005.length() > 0) line2_1005.append(" ");
                            line2_1005.append(words_1005[i_1005]);
                        }
                    }
                    String l1_1005 = line1_1005.toString();
                    String l2_1005 = line2_1005.toString();
                    int w1_1005 = fm_1005.stringWidth(l1_1005);
                    int w2_1005 = fm_1005.stringWidth(l2_1005);
                    g2d_1005.drawString(l1_1005, x_1005 - (w1_1005 / 2), y_1005 - 2);
                    g2d_1005.drawString(l2_1005, x_1005 - (w2_1005 / 2), y_1005 + 13);
                } else {
                    int textWidth_1005 = fm_1005.stringWidth(shortName_1005);
                    g2d_1005.drawString(shortName_1005, x_1005 - (textWidth_1005 / 2), y_1005 + 5);
                }
            }
            
            // 4. Legenda
            drawLegend_1005(g2d_1005);
        }
        
        private void drawLegend_1005(Graphics2D g2d_1005) {
            int legendX_1005 = 20;
            int legendY_1005 = getHeight() - 140;
            int boxSize_1005 = 16;
            int gap_1005 = 24;
            
            Font legendFont_1005 = new Font("Arial", Font.PLAIN, 13);
            g2d_1005.setFont(legendFont_1005);
            
            String[] labels_1005 = {
                "Start Node", "Goal Node", "Edge pada Jalur", "Dikunjungi", "Belum Dikunjungi"
            };
            Color[] colors_1005 = {
                COLOR_START_1005, COLOR_GOAL_1005, COLOR_PATH_EDGE_1005, COLOR_VISITED_1005, COLOR_UNVISITED_1005
            };
            
            for (int i_1005 = 0; i_1005 < labels_1005.length; i_1005++) {
                int y_1005 = legendY_1005 + i_1005 * gap_1005;
                
                g2d_1005.setColor(colors_1005[i_1005]);
                g2d_1005.fillRect(legendX_1005, y_1005, boxSize_1005, boxSize_1005);
                
                g2d_1005.setColor(Color.DARK_GRAY);
                g2d_1005.drawRect(legendX_1005, y_1005, boxSize_1005, boxSize_1005);
                
                g2d_1005.setColor(Color.BLACK);
                g2d_1005.drawString(labels_1005[i_1005], legendX_1005 + boxSize_1005 + 8, y_1005 + boxSize_1005 - 3);
            }
        }
    }
    
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PetaPadang_2511531005 frame_1005 = new PetaPadang_2511531005();
            frame_1005.setVisible(true);
        });
    }
}