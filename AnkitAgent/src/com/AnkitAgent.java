package com;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * @author Ankit Singh
 *
 */
class AnkitAgent {

	/**
	 * 
	 */
	public AnkitAgent() {}
	
	public void executeAll() {
		//extractorConsole();
		extractorReport();
                extractorLog();
	}

	private void extractorConsole() {
		java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		// get current date time with Date()
		java.util.Date date = new java.util.Date();
		System.out.println("Execution Time (yyyy/MM/dd HH:mm:ss): " + dateFormat.format(date));

		// Java properties
		System.out.println("JRE version number: " + System.getProperty("java.version"));
		// The code below may break on non Sun Java systems - see the
		// is64BitVM() method
		// System.out.println("JRE bitness: " +
		// System.getProperty("sun.arch.data.model") + "bit");
		System.out.println("JRE vendor name: " + System.getProperty("java.vendor"));
		// System.out.println("JRE vendor URL: " +
		// System.getProperty("java.vendor.url"));
		System.out.println("Installation directory for JRE: " + System.getProperty("java.home") + "\n");
		// System.out.println("Path used to find directories and JAR archives
		// containing class files: " + System.getProperty("java.class.path"));

		// The key for getting operating system name
		String name = System.getProperty("os.name").toLowerCase();
		// The key for getting operating system version
		// String version = System.getProperty("os.version");
		// The key for getting operating system architecture
		// This reports even a 64bit OS as 32bit if 32bit Java is installed on a
		// 64bit OS @@@@@@@@@@@@@@@@@@@
		// String architecture = System.getProperty("os.arch");
		
		// System.out.println("OS Name: " + name);
		// System.out.println("OS Version: " + version);
		// System.out.println("OS Architecture: " + architecture);
		// System.getProperties().list(System.out);

		// String domainName = "google.com";
		// in mac oxs
		// String command = "ping -c 3 " + domainName;
		// in windows
		// String command = "ping -n 3 " + domainName;

		long startTime = System.nanoTime();
		// long endTime = System.nanoTime();
		// long duration = (endTime - startTime);
		
		if (name.contains("linux")) {
			System.out.println("@@@@@@@@@@@@@@@@ Operating System:\n" + executeCommand("uname -a"));
			System.out.println("@@@@@@@@@@@@@@@@ Hostname:\n" + executeCommand("hostname -s"));
			// System.out.println("@@@@@@@@@@@@@@@@ DNS:\n" +
			// executeCommand("hostname -d")); // INCORRECT COMMAND USAGE
			System.out.println("@@@@@@@@@@@@@@@@ Fully qualified domain name:\n" + executeCommand("hostname -f"));
			System.out.println("@@@@@@@@@@@@@@@@ Network Address (IP):\n" + executeCommand("hostname -i"));
			System.out
					.println("@@@@@@@@@@@@@@@@ IP Address (atmost four):\n" + executeCommand("ip -4 address show"));
			System.out.println("@@@@@@@@@@@@@@@@ IP Configuration:\n" + executeCommand("ifconfig -a"));
			// System.out.println("@@@@@@@@@@@@@@@@ RAM:\n" +
			// executeCommand("free -h")); // INCORRECT COMMAND USAGE
			System.out.println("@@@@@@@@@@@@@@@@ RAM (free and used) (buffers/cache):\n" + executeCommand("free"));
			System.out.println("@@@@@@@@@@@@@@@@ System RAM Usage:\n" + executeCommand("cat /proc/meminfo"));
			System.out.println("@@@@@@@@@@@@@@@@ Virtual Memory Statistics\n" + executeCommand("vmstat"));
			System.out.println("@@@@@@@@@@@@@@@@ CPU(s):\n" + executeCommand("lscpu"));
			System.out.println("@@@@@@@@@@@@@@@@ CPU (Physical/Core):\n" + executeCommand("cat /proc/cpuinfo"));
			// THE COMMAND BELOW WORKS IN TERMINAL BUT NOT HERE (PRODUCES NO
			// OUTPUT):
			// System.out.println("@@@@@@@@@@@@@@@@ Virtualization Info:\n" +
			// executeCommand("cat /var/log/dmesg | grep -i virtual"));
			// System.out.println(" "+executeCommand(""));
		} else if (name.contains(
				"nix") /* || name.contains("aix") || name.contains("nux") */) {
			System.out.println("Operating System:			" + executeCommand("uname -a"));
			System.out.println("Hostname:			" + executeCommand("hostname -s"));
			// System.out.println("DNS: "+executeCommand("hostname -d"));
			System.out.println("Fully qualified domain name:			" + executeCommand("hostname -f"));
			// System.out.println("Network Address (IP):
			// "+executeCommand("hostname -i"));
			// System.out.println("IP Address (atmost four):
			// "+executeCommand("ip -4 address show"));
			System.out.println("IP Configuration:			" + executeCommand("ifconfig -a"));
			// System.out.println("RAM: "+executeCommand("free -h"));
			// System.out.println(" "+executeCommand("free"));
			// System.out.println(" "+executeCommand("cat /proc/meminfo"));
			System.out.println("			" + executeCommand("vmstat"));
			// System.out.println("CPU: "+executeCommand("lscpu"));
			System.out.println("CPU:			" + executeCommand("sysctl hw.model hw.machine hw.ncpu"));
			System.out.println("Environment Info:			" + executeCommand("printenv"));
			// System.out.println("CPU number & cores: "+executeCommand("cat
			// /proc/cpuinfo"));
			// System.out.println("Virtualization info:
			// "+executeCommand("cat /var/log/dmesg | grep -i virtual"));
			// System.out.println(" "+executeCommand(""));

			if (name.contains("hp")) {
				System.out.println("Operating System version:			" + executeCommand("uname -r"));
				System.out.println("Software List:			" + executeCommand("swlist HPUX*OE*"));
				System.out.println("CPU config:			" + executeCommand("getconf HW_CPU_SUPP_BITS"));
				System.out.println("			" + executeCommand("glance"));
				System.out.println("Machine Info:			" + executeCommand("machinfo"));
				System.out.println("			" + executeCommand("ioscan -fnk | grep proc"));
				System.out.println("			" + executeCommand("ioscan -C processor"));
				System.out.println("			" + executeCommand("print_manifest"));
				// System.out.println(" "+executeCommand(""));
			}

			else if (name.contains("aix")) {
				System.out.println("Operating System:			" + executeCommand("oslevel -r"));
				System.out.println("Type of System:			" + executeCommand("uname -p"));
				System.out.println("OS Release Number:			" + executeCommand("uname -r"));
				System.out.println("OS Name:			" + executeCommand("uname -s"));
				System.out.println("Node Name			" + executeCommand("uname -n"));
				System.out.println("System Name, Node, ID, Machine:			" + executeCommand("uname -a"));
				System.out.println("System Model Name:			" + executeCommand("uname -M"));
				System.out.println("OS Version:			" + executeCommand("uname -v"));
				System.out.println("Machine ID number:			" + executeCommand("uname -m"));
				System.out.println("System ID number:			" + executeCommand("uname -u"));

				System.out.println("			" + executeCommand("prtconf"));
				System.out.println("Boot config:			" + executeCommand("bootinfo -y"));
				System.out.println("			" + executeCommand("lscfg"));
				System.out.println("			" + executeCommand("lsattr -El sys0 -a realmem"));
				// System.out.println(" "+executeCommand(""));
			}
		} else if (name.contains("win")) {
			// System.out.println("win");
			String output = executeCommand("SYSTEMINFO");
			System.out.println(output);

		} else if (name.contains("sunos")) {
			System.out.println("solaris");
		} else if (name.contains("mac")) {
			System.out.println("mac");
		} else if (name.contains("bsd")) {
			System.out.println("BSD");
		} else if (name.contains("risc")) {
			System.out.println("RISC OS");
		} else if (name.contains("vms")) {
			System.out.println("OpenVMS");
		}
		// Dominant Mainframe OS (all by IBM): z/OS, z/VM, z/VSE, Linux on z
		// Systems, z/TPF
		
		// dividing by 1000000 to get milliseconds.
		System.out.println("Duration (milliseconds): " + (System.nanoTime() - startTime) / 1000000);
		System.out.println("UserTime   = " + getUserTime()/1000000);
		System.out.println("SystemTime = " + getSystemTime()/1000000);
		System.out.println("CpuTime    = " + getCpuTime()/1000000);
	}
	
	private void extractorReport() {
		boolean append = false;
		boolean autoFlush = true;
		String filePath = "Report.txt";
		java.io.File file = new java.io.File(filePath);
		java.io.PrintWriter pw = null;
		try {
			java.io.FileWriter fw = new java.io.FileWriter(file,append);
            java.io.BufferedWriter bw = new java.io.BufferedWriter(fw);
			pw = new java.io.PrintWriter(bw, autoFlush);
			pw.println("\tInfrastructure: Server");
			String name = System.getProperty("os.name").toLowerCase();
                    
			long startTime = System.nanoTime();
			
			if (name.contains("linux")) {
				pw.println("\tFull Domain Name\t\t\t: " + executeCommandSLO("hostname -f") + "." + executeCommandSLO("hostname -s") + "." + executeCommandSLO("domainname") );
//				System.out.println("@@@@@@@@@@@@@@@@ Fully qualified domain name:\n" + executeCommand("hostname -f"));
				
				pw.println("\tNetwork: For all interfaces");
				  pw.print("\tName\t\t\t\t: ");
			String ip = "NULL";
                        ip = executeCommand("ip -4 address");
			int count = subStringCount(ip , "eth");
                        if (count==0) {
                            pw.println("NULL");
                        }
                        else {
                            for (int i=0; i<count; i++)
                            {
                            pw.print("eth" + i + " | ");
                            }
			pw.println();
			
			pw.print("\tIP Address\t\t\t: ");
                        ip = ip.substring( ip.indexOf("inet")+17 , ip.length() );
			while ( ip.contains("inet") )
			{
			    //System.out.println( "1st: " + ip );
				pw.print( ip.substring( (ip.indexOf("inet")+5) , ip.indexOf("/") ) + " | ");
			    ip = ip.substring( ip.indexOf("inet")+17 , ip.length() );
			    //System.out.println( "3rd: " + ip );
			}
                        }
			    pw.println();
			    
			    pw.println("\tInfrastructure: Hardware");
			    pw.print("\tVendor\t\t\t\t\t: ");
                            
                            String dmesg = "NULL";
                            dmesg = executeCommand("dmesg");
                            //String lshal = executeCommand("lshal > lshalFile.txt");// DOES NOT WORK
			    //System.out.println( dmesg );
                            int indexOfDMI = dmesg.indexOf("DMI:", 100);
			    if ( !(indexOfDMI < 0) ) {
                                String vendorAndModel = dmesg.substring( indexOfDMI+5, dmesg.indexOf("/", indexOfDMI+7) );
                                //System.out.println( vendorAndModel );
                                int lastSpaceIndex = vendorAndModel.lastIndexOf(" ");
                                pw.println( vendorAndModel.substring( 0, lastSpaceIndex ) );
                                //System.out.println( vendorAndModel.substring( 0, lastSpaceIndex ) );
                                pw.print("\tModel\t\t\t\t\t: ");
                                pw.println(vendorAndModel.substring( lastSpaceIndex+1 ) );
                                //System.out.println( vendorAndModel.substring( lastSpaceIndex+1 ) );
                            }
                            else {
                                pw.println("NULL");
                                pw.print("\tModel\t\t\t\t\t: ");
                                pw.println("NULL");
                            }
                            
			    pw.print("\tVirtual\t\t\t\t\t: ");
                            if ( dmesg.contains("virtual") ) {
                                pw.println("YES");
                            }
			    else {
			        pw.println("NO");
			    }
                            
			    pw.println("	CPU");
                            
			    String newline = System.getProperty("line.separator");
                            // CPU Vendor
			    pw.print("\tVendor\t\t\t\t: ");
			    int indexOfCPU0 = dmesg.indexOf("CPU0:", indexOfDMI+100);
			    if ( !(indexOfCPU0 < 0) ) {
                                String vendorNameSpeed = dmesg.substring( indexOfCPU0+6, dmesg.indexOf("GHz", indexOfDMI+7) );
                                //System.out.println( vendorNameSpeed );
                                pw.println(vendorNameSpeed.substring(0, vendorNameSpeed.indexOf(" ")));
                                
                                // CPU Name
                                pw.print("\tName\t\t\t\t: ");
                                pw.println(vendorNameSpeed.substring(vendorNameSpeed.indexOf(" ")+1, nthOccurrence(vendorNameSpeed,' ',2)));
                                //System.out.println(vendorNameSpeed.substring(vendorNameSpeed.indexOf(" ")+1, nthOccurrence(vendorNameSpeed,' ',2)));
                                
                                String lscpu = "NULL";
                                lscpu = executeCommand("lscpu");
                                
                                // No. of Processors and cores
                                pw.print("\tProcessors and Cores\t\t: ");
                                // No. of Processors
                                int indexOfProc = lscpu.indexOf("Socket(s):");
                                if ( !(indexOfProc < 0) ) {
                                    //System.out.println("newline=" + newline);
                                    //System.out.println("indexOfProc=" + indexOfProc);
                                    String proc = lscpu.substring(indexOfProc, lscpu.indexOf(newline, indexOfProc));
                                    //System.out.println(Proc.substring( Proc.lastIndexOf(" ")+1 ));
                                    pw.print(proc.substring( proc.lastIndexOf(" ")+1 ) + " x ");
                                    
                                    // No. of cores
                                    int indexOfCore = lscpu.indexOf("Core(s) per socket:");
                                    if ( !(indexOfCore < 0) ) {
                                        String core = lscpu.substring(indexOfCore, lscpu.indexOf(newline, indexOfCore));
                                        pw.println(core.substring( core.lastIndexOf(" ")+1 ));
                                    }                                    
                                }
                                
                                // Architecture
                                pw.print("\tArchitecture\t\t\t: ");
                                int indexOfArch = lscpu.indexOf("Architecture:");
                                if ( !(indexOfArch < 0) ) {
                                    String arch = lscpu.substring(indexOfArch, lscpu.indexOf(newline, indexOfArch));
                                    pw.println(arch.substring( arch.lastIndexOf(" ")+1 ));
                                }
                                
                                pw.print("\tSpeed\t\t\t\t: ");
                                pw.println(vendorNameSpeed.substring( vendorNameSpeed.lastIndexOf(" ")+1 )+" Ghz");
                            }
                            else{
                                pw.println("NULL");
                            }

                            // RAM
			    pw.print("\tRAM\t\t\t\t\t: ");
                            String free = executeCommand("free");
			    int indexOfColon = free.indexOf(":");
			    if ( !(indexOfColon < 0) ) {
                                String ram = free.substring(indexOfColon+1, free.indexOf(newline, indexOfColon));
                                //System.out.println(ram);
                                int i=0;
                                while ( ram.charAt(i)==' ' && i<ram.length() ){
                                        //System.out.print(ram.charAt(i)+". ");
                                        i++;
                                    }
                                //System.out.println();
                                int j=i;
                                while ( ram.charAt(j)!=' ' && i<ram.length() ){
                                        //System.out.print(ram.charAt(j)+", ");
                                        j++;
                                    }
                                //System.out.println();
                                //System.out.println( ram.substring(i, j) );
                                float ramKB = Float.parseFloat(ram.substring(i, j));
                                //System.out.println(Math.round(ramKB/1048576));
                                pw.println(Math.round(ramKB/1048576) + " GiB");
                            }
                            else{
                                pw.println("NULL");
                            }
                            
			    pw.print("\tHard Disk\t\t\t\t: ");
			    int indexOfGiB = dmesg.indexOf("GiB)");
			    //System.out.print(indexOfGiB+"-"+dmesg.length());
                if(!(indexOfGiB < 0)) {
			    while ( !(indexOfGiB < 0) && indexOfGiB < dmesg.length()) {
			        //System.out.println( dmesg.charAt(dmesg.indexOf("/", indexOfGiB-15)) );
			        //System.out.println( dmesg.charAt(indexOfGiB+3 ) );
			        pw.print(dmesg.substring(dmesg.indexOf("/", indexOfGiB-15)+1, indexOfGiB+3) + " | ");
			        indexOfGiB = dmesg.indexOf("GiB)", indexOfGiB+3);
			        //System.out.print(indexOfGiB+"-"+dmesg.length());
			    }
			    //pw.println();
                }
                            else{
                                pw.println("NULL");
                            }
			
			//System.out.println("@@@@@@@@@@@@@@@@ Operating System:\n" + executeCommand("uname -a"));
			//System.out.println("@@@@@@@@@@@@@@@@ Hostname:\n" + executeCommand("hostname -s"));
				// System.out.println("@@@@@@@@@@@@@@@@ DNS:\n" + executeCommand("hostname -d")); // INCORRECT COMMAND USAGE
			//System.out.println("@@@@@@@@@@@@@@@@ Network Address (IP):\n" + executeCommand("hostname -i"));
			//System.out.println("@@@@@@@@@@@@@@@@ IP Address (atmost four):\n" + executeCommand("ip -4 address show"));
			//System.out.println("@@@@@@@@@@@@@@@@ IP Configuration:\n" + executeCommand("ifconfig -a"));
				// System.out.println("@@@@@@@@@@@@@@@@ RAM:\n" + executeCommand("free -h")); // INCORRECT COMMAND USAGE
			//System.out.println("@@@@@@@@@@@@@@@@ RAM (free and used) (buffers/cache):\n" + executeCommand("free"));
			//System.out.println("@@@@@@@@@@@@@@@@ System RAM Usage:\n" + executeCommand("cat /proc/meminfo"));
			//System.out.println("@@@@@@@@@@@@@@@@ Virtual Memory Statistics\n" + executeCommand("vmstat"));
			//System.out.println("@@@@@@@@@@@@@@@@ CPU(s):\n" + executeCommand("lscpu"));
			//System.out.println("@@@@@@@@@@@@@@@@ CPU (Physical/Core):\n" + executeCommand("cat /proc/cpuinfo"));
				// THE COMMAND BELOW WORKS IN TERMINAL BUT NOT HERE (PRODUCES NO OUTPUT):
				// System.out.println("@@@@@@@@@@@@@@@@ Virtualization Info:\n" + executeCommand("cat /var/log/dmesg | grep -i virtual"));
				// System.out.println(" "+executeCommand(""));
			} else if (name.contains("nix") /* || name.contains("aix") || name.contains("nux") */) {
				System.out.println("Operating System:			" + executeCommand("uname -a"));
				System.out.println("Hostname:			" + executeCommand("hostname -s"));
				// System.out.println("DNS: "+executeCommand("hostname -d"));
				System.out.println("Fully qualified domain name:			" + executeCommand("hostname -f"));
				// System.out.println("Network Address (IP):
				// "+executeCommand("hostname -i"));
				// System.out.println("IP Address (atmost four):
				// "+executeCommand("ip -4 address show"));
				System.out.println("IP Configuration:			" + executeCommand("ifconfig -a"));
				// System.out.println("RAM: "+executeCommand("free -h"));
				// System.out.println(" "+executeCommand("free"));
				// System.out.println(" "+executeCommand("cat /proc/meminfo"));
				System.out.println("			" + executeCommand("vmstat"));
				// System.out.println("CPU: "+executeCommand("lscpu"));
				System.out.println("CPU:			" + executeCommand("sysctl hw.model hw.machine hw.ncpu"));
				System.out.println("Environment Info:			" + executeCommand("printenv"));
				// System.out.println("CPU number & cores: "+executeCommand("cat
				// /proc/cpuinfo"));
				// System.out.println("Virtualization info:
				// "+executeCommand("cat /var/log/dmesg | grep -i virtual"));
				// System.out.println(" "+executeCommand(""));

				if (name.contains("hp")) {
					System.out.println("Operating System version:			" + executeCommand("uname -r"));
					System.out.println("Software List:			" + executeCommand("swlist HPUX*OE*"));
					System.out.println("CPU config:			" + executeCommand("getconf HW_CPU_SUPP_BITS"));
					System.out.println("			" + executeCommand("glance"));
					System.out.println("Machine Info:			" + executeCommand("machinfo"));
					System.out.println("			" + executeCommand("ioscan -fnk | grep proc"));
					System.out.println("			" + executeCommand("ioscan -C processor"));
					System.out.println("			" + executeCommand("print_manifest"));
					// System.out.println(" "+executeCommand(""));
				}

				else if (name.contains("aix")) {
					System.out.println("Operating System:			" + executeCommand("oslevel -r"));
					System.out.println("Type of System:			" + executeCommand("uname -p"));
					System.out.println("OS Release Number:			" + executeCommand("uname -r"));
					System.out.println("OS Name:			" + executeCommand("uname -s"));
					System.out.println("Node Name			" + executeCommand("uname -n"));
					System.out.println("System Name, Node, ID, Machine:			" + executeCommand("uname -a"));
					System.out.println("System Model Name:			" + executeCommand("uname -M"));
					System.out.println("OS Version:			" + executeCommand("uname -v"));
					System.out.println("Machine ID number:			" + executeCommand("uname -m"));
					System.out.println("System ID number:			" + executeCommand("uname -u"));

					System.out.println("			" + executeCommand("prtconf"));
					System.out.println("Boot config:			" + executeCommand("bootinfo -y"));
					System.out.println("			" + executeCommand("lscfg"));
					System.out.println("			" + executeCommand("lsattr -El sys0 -a realmem"));
					// System.out.println(" "+executeCommand(""));
				}
			} else if (name.contains("win")) {
				// System.out.println("win");
				String output = executeCommand("SYSTEMINFO");
				pw.println(output);
			} else if (name.contains("sunos")) {
				System.out.println("solaris");
			} else if (name.contains("mac")) {
				System.out.println("mac");
			} else if (name.contains("bsd")) {
				System.out.println("BSD");
			} else if (name.contains("risc")) {
				System.out.println("RISC OS");
			} else if (name.contains("vms")) {
				System.out.println("OpenVMS");
			}
			// Dominant Mainframe OS (all by IBM): z/OS, z/VM, z/VSE, Linux on z
			// Systems, z/TPF
			
			pw.println();			
			pw.println();
			java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			java.util.Date date = new java.util.Date();
			pw.println("Execution Time (yyyy/MM/dd HH:mm:ss): " + dateFormat.format(date));
			pw.println("Duration (milliseconds):              " + (System.nanoTime() - startTime) / 1000000);
			pw.println("UserTime (milliseconds):              " + getUserTime()/1000000);
			pw.println("SystemTime (milliseconds):            " + getSystemTime()/1000000);
			pw.println("CpuTime (milliseconds):               " + getCpuTime()/1000000);
		}
		catch (java.io.FileNotFoundException e) {
			System.out.println("***** FILE NOT FOUND EXCEPTION *****");
			Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
		}
		catch (java.io.UnsupportedEncodingException e) {
			System.out.println("***** UNSUPPORTED ENCODING EXCEPTION *****");
			Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
		}
		catch (java.io.IOException e) {
			System.out.println("***** IO EXCEPTION *****");
			Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
		}
		finally
		{
			pw.close();
		}
	}
	
    private void extractorLog() {
            boolean append = false;
            boolean autoFlush = true;
            String filePath = "Log.txt";
            java.io.File file = new java.io.File(filePath);
            java.io.PrintWriter pw = null;
            try {
                    java.io.FileWriter fw = new java.io.FileWriter(file,append);
        java.io.BufferedWriter bw = new java.io.BufferedWriter(fw);
                    pw = new java.io.PrintWriter(bw, autoFlush);
                    pw.println("\tInfrastructure: Server");
                    String name = System.getProperty("os.name").toLowerCase();
                
                    long startTime = System.nanoTime();
                    
                    if (name.contains("linux")) {
                            pw.println("@@@@@@@@@@@@@@@@@@@@@ Full Domain Name @@@@@@@@@@@@@@@@@@@@@");
                            pw.println("--------------------- hostname -f:");
                            pw.println(executeCommandSLO("hostname -f"));
                            pw.println("--------------------- hostname -s");
                            pw.println(executeCommandSLO("hostname -s"));
                            pw.println("--------------------- domainname:");
                            pw.println(executeCommandSLO("domainname"));
    //                              System.out.println("@@@@@@@@@@@@@@@@ Fully qualified domain name:\n" + executeCommand("hostname -f"));
                            
                            pw.println("@@@@@@@@@@@@@@@@@@@@@ Network: For all interfaces");
                            pw.println("@@@@@@@@@@@@@@@@@@@@@ Name:");
                    pw.println("--------------------- ip -4 address:");
                    pw.println(executeCommand("ip -4 address"));
                    String ip = "NULL";
                    ip = executeCommand("ip -4 address");
                    
                    //int count = subStringCount(ip , "eth");
                    //if (count==0) {
                        //pw.println("NULL");
                    //}
                    //else {
                        //for (int i=0; i<count; i++)
                        //{
                        //pw.print("eth" + i + " | ");
                        //}
                    //pw.println();
                    
                    //pw.print("\tIP Address\t\t\t: ");
                    //ip = ip.substring( ip.indexOf("inet")+17 , ip.length() );
                    //while ( ip.contains("inet") )
                    //{
                        //System.out.println( "1st: " + ip );
                            //pw.print( ip.substring( (ip.indexOf("inet")+5) , ip.indexOf("/") ) + " | ");
                        //ip = ip.substring( ip.indexOf("inet")+17 , ip.length() );
                        //System.out.println( "3rd: " + ip );
                    //}
                    //}
                        //pw.println();
                        
                        pw.println("@@@@@@@@@@@@@@@@@@@@@ Infrastructure: Hardware:");
                        pw.print("@@@@@@@@@@@@@@@@@@@@@ Vendor:");
                        pw.print("--------------------- dmesg:");
                        pw.print(executeCommand("dmesg"));
                        
                        String dmesg = "NULL";
                        dmesg = executeCommand("dmesg");
                        //String lshal = executeCommand("lshal > lshalFile.txt");// DOES NOT WORK
                        //System.out.println( dmesg );
                        int indexOfDMI = dmesg.indexOf("DMI:", 100);
                        if ( !(indexOfDMI < 0) ) {
                            String vendorAndModel = dmesg.substring( indexOfDMI+5, dmesg.indexOf("/", indexOfDMI+7) );
                            //System.out.println( vendorAndModel );
                            int lastSpaceIndex = vendorAndModel.lastIndexOf(" ");
                            //pw.println( vendorAndModel.substring( 0, lastSpaceIndex ) );
                            //System.out.println( vendorAndModel.substring( 0, lastSpaceIndex ) );
                            pw.print("@@@@@@@@@@@@@@@@@@@@@ Model");
                            //pw.println(vendorAndModel.substring( lastSpaceIndex+1 ) );
                            //System.out.println( vendorAndModel.substring( lastSpaceIndex+1 ) );
                        }
                        else {
                            //pw.println("NULL");
                            //pw.print("\tModel\t\t\t\t\t: ");
                            //pw.println("NULL");
                        }
                        
                        pw.print("@@@@@@@@@@@@@@@@@@@@@ Virtual:");
                        /*if ( dmesg.contains("virtual") ) {
                            pw.println("YES");
                        }
                        else {
                            pw.println("NO");
                        }*/
                        
                        pw.println("@@@@@@@@@@@@@@@@@@@@@ CPU");
                        
                        String newline = System.getProperty("line.separator");
                        // CPU Vendor
                        pw.print("@@@@@@@@@@@@@@@@@@@@@ Vendor:");
                        int indexOfCPU0 = dmesg.indexOf("CPU0:", indexOfDMI+100);
                        if ( !(indexOfCPU0 < 0) ) {
                            String vendorNameSpeed = dmesg.substring( indexOfCPU0+6, dmesg.indexOf("GHz", indexOfDMI+7) );
                            //System.out.println( vendorNameSpeed );
                            //pw.println(vendorNameSpeed.substring(0, vendorNameSpeed.indexOf(" ")));
                            
                            // CPU Name
                            pw.print("@@@@@@@@@@@@@@@@@@@@@ Name: ");
                            //pw.println(vendorNameSpeed.substring(vendorNameSpeed.indexOf(" ")+1, nthOccurrence(vendorNameSpeed,' ',2)));
                            //System.out.println(vendorNameSpeed.substring(vendorNameSpeed.indexOf(" ")+1, nthOccurrence(vendorNameSpeed,' ',2)));
                            
                            

                            pw.print("--------------------- lscpu:");
                            pw.print(executeCommand("lscpu"));
                            String lscpu = "NULL";
                            lscpu = executeCommand("lscpu");
                            
                            // No. of Processors and cores
                            pw.print("@@@@@@@@@@@@@@@@@@@@@ Processors and Cores: ");
                            // No. of Processors
                            int indexOfProc = lscpu.indexOf("Socket(s):");
                            if ( !(indexOfProc < 0) ) {
                                //System.out.println("newline=" + newline);
                                //System.out.println("indexOfProc=" + indexOfProc);
                                String proc = lscpu.substring(indexOfProc, lscpu.indexOf(newline, indexOfProc));
                                //System.out.println(Proc.substring( Proc.lastIndexOf(" ")+1 ));
                                //pw.print(proc.substring( proc.lastIndexOf(" ")+1 ) + " x ");
                                
                                // No. of cores
                                int indexOfCore = lscpu.indexOf("Core(s) per socket:");
                                if ( !(indexOfCore < 0) ) {
                                    String core = lscpu.substring(indexOfCore, lscpu.indexOf(newline, indexOfCore));
                                    //pw.println(core.substring( core.lastIndexOf(" ")+1 ));
                                }                                    
                            }
                            
                            // Architecture
                            pw.print("@@@@@@@@@@@@@@@@@@@@@ Architecture:");
                            int indexOfArch = lscpu.indexOf("Architecture:");
                            if ( !(indexOfArch < 0) ) {
                                String arch = lscpu.substring(indexOfArch, lscpu.indexOf(newline, indexOfArch));
                                //pw.println(arch.substring( arch.lastIndexOf(" ")+1 ));
                            }
                            
                            pw.print("@@@@@@@@@@@@@@@@@@@@@ Speed:");
                            //pw.println(vendorNameSpeed.substring( vendorNameSpeed.lastIndexOf(" ")+1 )+" Ghz");
                        }
                        else{
                            //pw.println("NULL");
                        }

                        // RAM
                        pw.print("@@@@@@@@@@@@@@@@@@@@@ RAM:");
                        pw.println("@@@@@@@@@@@@@@@@@@@@@ Name:");
                        pw.println("--------------------- free:");
                        pw.println(executeCommand("free"));
                        
                        
                        String free = executeCommand("free");
                        int indexOfColon = free.indexOf(":");
                        if ( !(indexOfColon < 0) ) {
                            String ram = free.substring(indexOfColon+1, free.indexOf(newline, indexOfColon));
                            //System.out.println(ram);
                            int i=0;
                            while ( ram.charAt(i)==' ' && i<ram.length() ){
                                    //System.out.print(ram.charAt(i)+". ");
                                    i++;
                                }
                            //System.out.println();
                            int j=i;
                            while ( ram.charAt(j)!=' ' && i<ram.length() ){
                                    //System.out.print(ram.charAt(j)+", ");
                                    j++;
                                }
                            //System.out.println();
                            //System.out.println( ram.substring(i, j) );
                            float ramKB = Float.parseFloat(ram.substring(i, j));
                            //System.out.println(Math.round(ramKB/1048576));
                            //pw.println(Math.round(ramKB/1048576) + " GiB");
                        }
                        else{
                            //pw.println("NULL");
                        }
                        
                        pw.print("@@@@@@@@@@@@@@@@@@@@@ Hard Disk:");                        
                        pw.print("- - - - - dmesg:");
                        int indexOfGiB = dmesg.indexOf("GiB)");
                        //System.out.print(indexOfGiB+"-"+dmesg.length());
            if(!(indexOfGiB < 0)) {
                        while ( !(indexOfGiB < 0) && indexOfGiB < dmesg.length()) {
                            //System.out.println( dmesg.charAt(dmesg.indexOf("/", indexOfGiB-15)) );
                            //System.out.println( dmesg.charAt(indexOfGiB+3 ) );
                            //pw.print(dmesg.substring(dmesg.indexOf("/", indexOfGiB-15)+1, indexOfGiB+3) + " | ");
                            indexOfGiB = dmesg.indexOf("GiB)", indexOfGiB+3);
                            //System.out.print(indexOfGiB+"-"+dmesg.length());
                        }
                        pw.println();
            }
                        else{
                            pw.println("NULL");
                        }
                    
                    //System.out.println("@@@@@@@@@@@@@@@@ Operating System:\n" + executeCommand("uname -a"));
                    //System.out.println("@@@@@@@@@@@@@@@@ Hostname:\n" + executeCommand("hostname -s"));
                            // System.out.println("@@@@@@@@@@@@@@@@ DNS:\n" + executeCommand("hostname -d")); // INCORRECT COMMAND USAGE
                    //System.out.println("@@@@@@@@@@@@@@@@ Network Address (IP):\n" + executeCommand("hostname -i"));
                    //System.out.println("@@@@@@@@@@@@@@@@ IP Address (atmost four):\n" + executeCommand("ip -4 address show"));
                    //System.out.println("@@@@@@@@@@@@@@@@ IP Configuration:\n" + executeCommand("ifconfig -a"));
                            // System.out.println("@@@@@@@@@@@@@@@@ RAM:\n" + executeCommand("free -h")); // INCORRECT COMMAND USAGE
                    //System.out.println("@@@@@@@@@@@@@@@@ RAM (free and used) (buffers/cache):\n" + executeCommand("free"));
                    //System.out.println("@@@@@@@@@@@@@@@@ System RAM Usage:\n" + executeCommand("cat /proc/meminfo"));
                    //System.out.println("@@@@@@@@@@@@@@@@ Virtual Memory Statistics\n" + executeCommand("vmstat"));
                    //System.out.println("@@@@@@@@@@@@@@@@ CPU(s):\n" + executeCommand("lscpu"));
                    //System.out.println("@@@@@@@@@@@@@@@@ CPU (Physical/Core):\n" + executeCommand("cat /proc/cpuinfo"));
                            // THE COMMAND BELOW WORKS IN TERMINAL BUT NOT HERE (PRODUCES NO OUTPUT):
                            // System.out.println("@@@@@@@@@@@@@@@@ Virtualization Info:\n" + executeCommand("cat /var/log/dmesg | grep -i virtual"));
                            // System.out.println(" "+executeCommand(""));
                    } else if (name.contains("nix") /* || name.contains("aix") || name.contains("nux") */) {
                            System.out.println("Operating System:                   " + executeCommand("uname -a"));
                            System.out.println("Hostname:                   " + executeCommand("hostname -s"));
                            // System.out.println("DNS: "+executeCommand("hostname -d"));
                            System.out.println("Fully qualified domain name:                        " + executeCommand("hostname -f"));
                            // System.out.println("Network Address (IP):
                            // "+executeCommand("hostname -i"));
                            // System.out.println("IP Address (atmost four):
                            // "+executeCommand("ip -4 address show"));
                            System.out.println("IP Configuration:                   " + executeCommand("ifconfig -a"));
                            // System.out.println("RAM: "+executeCommand("free -h"));
                            // System.out.println(" "+executeCommand("free"));
                            // System.out.println(" "+executeCommand("cat /proc/meminfo"));
                            System.out.println("                    " + executeCommand("vmstat"));
                            // System.out.println("CPU: "+executeCommand("lscpu"));
                            System.out.println("CPU:                        " + executeCommand("sysctl hw.model hw.machine hw.ncpu"));
                            System.out.println("Environment Info:                   " + executeCommand("printenv"));
                            // System.out.println("CPU number & cores: "+executeCommand("cat
                            // /proc/cpuinfo"));
                            // System.out.println("Virtualization info:
                            // "+executeCommand("cat /var/log/dmesg | grep -i virtual"));
                            // System.out.println(" "+executeCommand(""));

                            if (name.contains("hp")) {
                                    System.out.println("Operating System version:                   " + executeCommand("uname -r"));
                                    System.out.println("Software List:                      " + executeCommand("swlist HPUX*OE*"));
                                    System.out.println("CPU config:                 " + executeCommand("getconf HW_CPU_SUPP_BITS"));
                                    System.out.println("                    " + executeCommand("glance"));
                                    System.out.println("Machine Info:                       " + executeCommand("machinfo"));
                                    System.out.println("                    " + executeCommand("ioscan -fnk | grep proc"));
                                    System.out.println("                    " + executeCommand("ioscan -C processor"));
                                    System.out.println("                    " + executeCommand("print_manifest"));
                                    // System.out.println(" "+executeCommand(""));
                            }

                            else if (name.contains("aix")) {
                                    System.out.println("Operating System:                   " + executeCommand("oslevel -r"));
                                    System.out.println("Type of System:                     " + executeCommand("uname -p"));
                                    System.out.println("OS Release Number:                  " + executeCommand("uname -r"));
                                    System.out.println("OS Name:                    " + executeCommand("uname -s"));
                                    System.out.println("Node Name                   " + executeCommand("uname -n"));
                                    System.out.println("System Name, Node, ID, Machine:                     " + executeCommand("uname -a"));
                                    System.out.println("System Model Name:                  " + executeCommand("uname -M"));
                                    System.out.println("OS Version:                 " + executeCommand("uname -v"));
                                    System.out.println("Machine ID number:                  " + executeCommand("uname -m"));
                                    System.out.println("System ID number:                   " + executeCommand("uname -u"));

                                    System.out.println("                    " + executeCommand("prtconf"));
                                    System.out.println("Boot config:                        " + executeCommand("bootinfo -y"));
                                    System.out.println("                    " + executeCommand("lscfg"));
                                    System.out.println("                    " + executeCommand("lsattr -El sys0 -a realmem"));
                                    // System.out.println(" "+executeCommand(""));
                            }
                    } else if (name.contains("win")) {
                            // System.out.println("win");
                            String output = executeCommand("SYSTEMINFO");
                            pw.println(output);
                    } else if (name.contains("sunos")) {
                            System.out.println("solaris");
                    } else if (name.contains("mac")) {
                            System.out.println("mac");
                    } else if (name.contains("bsd")) {
                            System.out.println("BSD");
                    } else if (name.contains("risc")) {
                            System.out.println("RISC OS");
                    } else if (name.contains("vms")) {
                            System.out.println("OpenVMS");
                    }
                    // Dominant Mainframe OS (all by IBM): z/OS, z/VM, z/VSE, Linux on z
                    // Systems, z/TPF
                    
                    pw.println();                   
                    pw.println();
                    java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    java.util.Date date = new java.util.Date();
                    pw.println("Execution Time (yyyy/MM/dd HH:mm:ss): " + dateFormat.format(date));
                    pw.println("Duration (milliseconds):              " + (System.nanoTime() - startTime) / 1000000);
                    pw.println("UserTime (milliseconds):              " + getUserTime()/1000000);
                    pw.println("SystemTime (milliseconds):            " + getSystemTime()/1000000);
                    pw.println("CpuTime (milliseconds):               " + getCpuTime()/1000000);
            }
            catch (java.io.FileNotFoundException e) {
                    System.out.println("***** FILE NOT FOUND EXCEPTION *****");
                    Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, e);
                    e.printStackTrace();
            }
            catch (java.io.UnsupportedEncodingException e) {
                    System.out.println("***** UNSUPPORTED ENCODING EXCEPTION *****");
                    Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, e);
                    e.printStackTrace();
            }
            catch (java.io.IOException e) {
                    System.out.println("***** IO EXCEPTION *****");
                    Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, e);
                    e.printStackTrace();
            }
            finally
            {
                    pw.close();
            }
    }
        
	private String executeCommand(String command) {

		StringBuffer output = new StringBuffer();

		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(p.getInputStream()));

			String line = "";
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}
		} catch (Exception e) {
			System.out.println("***** AN EXCEPTION OCCURRED IN executeCommand() METHOD *****");
			e.printStackTrace();
		}
		return output.toString();
	}

	// SLO = Single Line Output
	private String executeCommandSLO(String command) {

		StringBuffer output = new StringBuffer();

		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(p.getInputStream()));

			String line = "";
			while ((line = reader.readLine()) != null) {
				output.append(line);
			}
		} catch (Exception e) {
			System.out.println("***** AN EXCEPTION OCCURRED IN executeCommand() METHOD *****");
			e.printStackTrace();
		}
		return output.toString();
	}

private int subStringCount(String str, String findStr) {
//String str = "helloslkhellodjladfjhello";
//String findStr = "hello";
int lastIndex = 0;
int count = 0;

while(lastIndex != -1){

    lastIndex = str.indexOf(findStr,lastIndex);

    if(lastIndex != -1){
        count ++;
        lastIndex += findStr.length();
    }
}
return(count/2);
}

    public static int nthOccurrence(String str, char c, int n) {
            //System.out.println("nthOccurence method called");
            int pos = str.indexOf(c, 0);
            int pos2=0;
    //              System.out.println("pos=" + pos);
            while (n-- > 0 && pos != -1 /* && pos < str.length() */ ) {
                    pos2 = str.indexOf(c, pos + 1);
                    if (pos2 != -1)
                    {
                            pos=pos2;
                    }
                    else
                    {
    //                              System.out.println(str + "pos=" + pos);
                    }
    //                      System.out.println("pos=" + pos);
            }
    //              System.out.println("pos=" + pos);
            return pos;
    }

	// public static boolean is64BitVM() {
	// String bits = System.getProperty("sun.arch.data.model", "?");
	// if (bits.equals("64")) {
	// return true;
	// }
	// if (bits.equals("?")) {
	// // probably sun.arch.data.model isn't available
	// // maybe not a Sun JVM?
	// // try with the "vm.name" property
	// return System.getProperty("java.vm.name").toLowerCase().indexOf(
	// "64") >= 0;
	// }
	// // probably 32bit
	// return false;
	// }

	
	// System.currentTimeMillis(); IS NOT a good approach for measuring
	// performance of algorithms. It measures the total time one experiences
	// as a user watching the computer screen, waiting till the program
	// finishes. It includes even time consumed by everything else running on
	// the computer in the background. This could make a huge difference in
	// case you have a lot of programs running on your workstation. Proper
	// approach is using java.lang.management package.
	// 1. "User time" is the time spent running your application's own code.
	// 2. "System time" is the time spent running OS code on behalf of your
	//    application (such as for I/O).
	// 3. getCpuTime() method gives you sum of those.

	/** Get CPU time in nanoseconds. */
	public static long getCpuTime() {
		ThreadMXBean bean = ManagementFactory.getThreadMXBean();
		return bean.isCurrentThreadCpuTimeSupported() ? bean.getCurrentThreadCpuTime() : 0L;
	}

	/** Get user time in nanoseconds. */
	public static long getUserTime() {
		ThreadMXBean bean = ManagementFactory.getThreadMXBean();
		return bean.isCurrentThreadCpuTimeSupported() ? bean.getCurrentThreadUserTime() : 0L;
	}

	/** Get system time in nanoseconds. */
	public static long getSystemTime() {
		ThreadMXBean bean = ManagementFactory.getThreadMXBean();
		return bean.isCurrentThreadCpuTimeSupported()
				? (bean.getCurrentThreadCpuTime() - bean.getCurrentThreadUserTime()) : 0L;
	}

}
