package iplacex.evaluacion;
import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.net.InetAddress;
import java.net.UnknownHostException;
import oshi.SystemInfo;
import oshi.hardware.GraphicsCard;

public class App 
{
	 public static void main(String[] args) {
	        obtenerSisSpec();
	 }
	 
	 public static void obtenerSisSpec() {
	        // Información del sistema operativo
	        OperatingSystemMXBean os = ManagementFactory.getOperatingSystemMXBean();
	        System.out.println("Sistema Operativo: " + os.getName() + " " + os.getVersion());
	        System.out.println("Arquitectura: " + os.getArch());
	        System.out.println("Número de CPUs: " + os.getAvailableProcessors());

	        // Información de la memoria (RAM)
	        long memoriaTotal = Runtime.getRuntime().totalMemory() / (1024 * 1024);
	        long memoriaLibre = Runtime.getRuntime().freeMemory() / (1024 * 1024);
	        long memoriaMaxima = Runtime.getRuntime().maxMemory() / (1024 * 1024);
	        System.out.println("Memoria Total (MB): " + memoriaTotal);
	        System.out.println("Memoria Libre (MB): " + memoriaLibre);
	        System.out.println("Memoria Máxima (MB): " + memoriaMaxima);

	        // Información de la dirección IP del equipo
	        try {
	            InetAddress ip = InetAddress.getLocalHost();
	            System.out.println("Dirección IP: " + ip.getHostAddress());
	            System.out.println("Nombre del host: " + ip.getHostName());
	        } catch (UnknownHostException e) {
	            e.printStackTrace();
	        }

	        // Información de los discos duros
	        File[] discos = File.listRoots();
	        for (File disco : discos) {
	            long espacioTotal = disco.getTotalSpace() / (1024 * 1024 * 1024);
	            long espacioLibre = disco.getFreeSpace() / (1024 * 1024 * 1024);
	            System.out.println("Disco: " + disco.getAbsolutePath());
	            System.out.println("Espacio Total (GB): " + espacioTotal);
	            System.out.println("Espacio Libre (GB): " + espacioLibre);
	        }

	        // Información de la tarjeta gráfica (solo para Windows)
	        SystemInfo systemInfo = new SystemInfo();

	        // Obtener las tarjetas gráficas disponibles
	        for (GraphicsCard card : systemInfo.getHardware().getGraphicsCards()) {
	            System.out.println("Nombre de la tarjeta gráfica: " + card.getName());
	            System.out.println("Fabricante: " + card.getVendor());
	            System.out.println("Versión de la BIOS: " + card.getVersionInfo());
	            System.out.println("Memoria: " + card.getVRam() + " bytes");
	            System.out.println();
	        }
	    }

}
