import java.util.*;
import java.util.stream.*;

public class DNAAnalyzer {
    private static final Map<String, String> CODON_TABLE = new HashMap<>();
    private static final Map<Character, Character> COMPLEMENT = Map.of(
        'A', 'T', 'T', 'A', 'C', 'G', 'G', 'C'
    );
    
    static {
        CODON_TABLE.put("ATG", "Met"); CODON_TABLE.put("GCT", "Ala"); CODON_TABLE.put("GCC", "Ala");
        CODON_TABLE.put("GCA", "Ala"); CODON_TABLE.put("GCG", "Ala"); CODON_TABLE.put("TGT", "Cys");
        CODON_TABLE.put("TGC", "Cys"); CODON_TABLE.put("GAT", "Asp"); CODON_TABLE.put("GAC", "Asp");
        CODON_TABLE.put("GAA", "Glu"); CODON_TABLE.put("GAG", "Glu"); CODON_TABLE.put("TTT", "Phe");
        CODON_TABLE.put("TTC", "Phe"); CODON_TABLE.put("GGT", "Gly"); CODON_TABLE.put("GGC", "Gly");
        CODON_TABLE.put("GGA", "Gly"); CODON_TABLE.put("GGG", "Gly"); CODON_TABLE.put("CAT", "His");
        CODON_TABLE.put("CAC", "His"); CODON_TABLE.put("ATT", "Ile"); CODON_TABLE.put("ATC", "Ile");
        CODON_TABLE.put("ATA", "Ile"); CODON_TABLE.put("AAA", "Lys"); CODON_TABLE.put("AAG", "Lys");
        CODON_TABLE.put("TTG", "Leu"); CODON_TABLE.put("TTA", "Leu"); CODON_TABLE.put("CTT", "Leu");
        CODON_TABLE.put("CTC", "Leu"); CODON_TABLE.put("CTA", "Leu"); CODON_TABLE.put("CTG", "Leu");
        CODON_TABLE.put("AAT", "Asn"); CODON_TABLE.put("AAC", "Asn"); CODON_TABLE.put("CCT", "Pro");
        CODON_TABLE.put("CCC", "Pro"); CODON_TABLE.put("CCA", "Pro"); CODON_TABLE.put("CCG", "Pro");
        CODON_TABLE.put("CAA", "Gln"); CODON_TABLE.put("CAG", "Gln"); CODON_TABLE.put("CGT", "Arg");
        CODON_TABLE.put("CGC", "Arg"); CODON_TABLE.put("CGA", "Arg"); CODON_TABLE.put("CGG", "Arg");
        CODON_TABLE.put("AGT", "Ser"); CODON_TABLE.put("AGC", "Ser"); CODON_TABLE.put("TCT", "Ser");
        CODON_TABLE.put("TCC", "Ser"); CODON_TABLE.put("TCA", "Ser"); CODON_TABLE.put("TCG", "Ser");
        CODON_TABLE.put("ACT", "Thr"); CODON_TABLE.put("ACC", "Thr"); CODON_TABLE.put("ACA", "Thr");
        CODON_TABLE.put("ACG", "Thr"); CODON_TABLE.put("TGG", "Trp"); CODON_TABLE.put("TAT", "Tyr");
        CODON_TABLE.put("TAC", "Tyr"); CODON_TABLE.put("GTT", "Val"); CODON_TABLE.put("GTC", "Val");
        CODON_TABLE.put("GTA", "Val"); CODON_TABLE.put("GTG", "Val"); CODON_TABLE.put("TAA", "STOP");
        CODON_TABLE.put("TAG", "STOP"); CODON_TABLE.put("TGA", "STOP");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("🧬 DNA Sequence Analyzer");
        System.out.print("Enter DNA sequence: ");
        String dna = scanner.nextLine().toUpperCase().replaceAll("[^ATCG]", "");
        
        if (dna.length() < 3) {
            System.out.println("Sequence too short!");
            return;
        }
        
        analyzeSequence(dna);
    }
    
    private static void analyzeSequence(String dna) {
        System.out.println("\n📊 Analysis Results:");
        System.out.println("Sequence: " + dna);
        System.out.println("Length: " + dna.length() + " bases");
        
        // Base composition
        Map<Character, Long> baseCount = dna.chars()
            .mapToObj(c -> (char)c)
            .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        
        System.out.println("\nBase Composition:");
        baseCount.forEach((base, count) -> {
            double percent = (count * 100.0) / dna.length();
            System.out.printf("%c: %d (%.1f%%)%n", base, count, percent);
        });
        
        // GC content
        long gcCount = dna.chars().filter(c -> c == 'G' || c == 'C').count();
        double gcPercent = (gcCount * 100.0) / dna.length();
        System.out.printf("GC Content: %.1f%%%n", gcPercent);
        
        // Reverse complement
        String reverseComp = getReverseComplement(dna);
        System.out.println("Reverse Complement: " + reverseComp);
        
        // Find ORFs
        findOpenReadingFrames(dna);
        
        // Transcription
        String rna = transcribeDNA(dna);
        System.out.println("RNA Transcript: " + rna);
    }
    
    private static String getReverseComplement(String dna) {
        return new StringBuilder(dna)
            .reverse()
            .chars()
            .mapToObj(c -> COMPLEMENT.get((char)c))
            .map(String::valueOf)
            .collect(Collectors.joining());
    }
    
    private static void findOpenReadingFrames(String dna) {
        System.out.println("\n🔍 Open Reading Frames:");
        
        for (int frame = 0; frame < 3; frame++) {
            System.out.printf("Frame %d: ", frame + 1);
            boolean inOrf = false;
            StringBuilder protein = new StringBuilder();
            
            for (int i = frame; i <= dna.length() - 3; i += 3) {
                String codon = dna.substring(i, i + 3);
                String aminoAcid = CODON_TABLE.get(codon);
                
                if ("Met".equals(aminoAcid) && !inOrf) {
                    inOrf = true;
                    protein.setLength(0);
                }
                
                if (inOrf) {
                    protein.append(aminoAcid).append("-");
                    
                    if ("STOP".equals(aminoAcid)) {
                        System.out.print(protein + " ");
                        inOrf = false;
                    }
                }
            }
            
            if (protein.length() == 0) System.out.print("No ORF found");
            System.out.println();
        }
    }
    
    private static String transcribeDNA(String dna) {
        return dna.replace('T', 'U');
    }
}
