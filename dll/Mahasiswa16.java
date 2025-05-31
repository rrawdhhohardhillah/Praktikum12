package dll;

public class Mahasiswa16{
    public String nim;
    public String nama;
    public String kelas;
    public int ipk;

    public Mahasiswa16 (String nim, String nama,String kelas, int ipk){
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.ipk = ipk;
        
    }

    public void tampil (){
           System.out.println("NIM : " + nim + ", Nama : " + nama +", Kelas : "+ kelas + ", ipk :" + ipk); 
        }

}