package dll;

public class DoubleLinkedList16 {
    Node16 head;
    Node16 tail;

    public DoubleLinkedList16() {
        head = null;
        tail = null;
    }

     public boolean IsEmpty() {
     return head == null;
    }

    public void addFirst(Mahasiswa16 data) {
    Node16 newNode = new Node16(data);
    if (IsEmpty()) {
        head = tail = newNode;
    } else {
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

}

    public void addLast(Mahasiswa16 data) {
    Node16 newNode = new Node16(data);
    if (IsEmpty()) {
        head = tail = newNode;
    } else {
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

}

   public void insertAfter(String keyNim, Mahasiswa16 data) {
    Node16 current = head;

    while (current != null && !current.data.nim.equals(keyNim)) {
        current = current.next;
    }

    if (current == null) {
        System.out.println("Node dengan NIM " + keyNim + " tidak ditemukan.");
        return;
    }

    Node16 newNode = new Node16(data);

    if (current == tail) {
        current.next = newNode;
        newNode.prev = current;
        tail = newNode;
    } else {
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
    }

    System.out.println("Node berhasil disisipkan setelah NIM " + keyNim);
    
} 
    public void print() {
      if (IsEmpty()) {
        System.out.println("Linked list kosong !");
      }else{
        Node16 current = head;
        while (current != null) {
            current.data.tampil();
            current = current.next;
        }
        }
    }

    public void removeFirst() {
    if (IsEmpty()) {
        System.out.println("List kosong, tidak bisa dihapus.");
        return;
    } 

    Mahasiswa16 dataDihapus = tail.data;

    if (head == tail) {
        head = tail = null;
    } else {
        head = head.next;
        head.prev = null;
    }
    System.out.println("Data berhasil dihapus. Berikut data yang terhapus :");
    dataDihapus.tampil();
}

public void removeLast() {
    if (IsEmpty()) {
        System.out.println("List kosong, tidak bisa dihapus.");
        return;
    } 

    Mahasiswa16 dataDihapus = tail.data;

    if (head == tail) {
        head = tail = null;
    } else {
        tail = tail.prev;
        tail.next = null;
    }
    System.out.println("Data berhasil dihapus. Berikut data ynag terhapus :");
    dataDihapus.tampil();
}

public Node16 search(String keyNim) {
    Node16 current = head;
    while (current != null) {
        if (current.data.nim.equals(keyNim)) {
            return current;
        }
        current = current.next;
    }
    return null;
}

public void add(int index, Mahasiswa16 data) {
    if (index < 0) {
        System.out.println("Indeks tidak valid! Masukkan angka mulai dari 0.");
        return;
    }

    Node16 newNode = new Node16(data);

    if (index == 0) {
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        return;
    }

    Node16 current = head;
    int currentIndex = 0;

    while (current != null && currentIndex < index) {
        current = current.next;
        currentIndex++;
    }

    if (current == null) {
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    } else {
        Node16 previous = current.prev;
        previous.next = newNode;
        newNode.prev = previous;
        newNode.next = current;
        current.prev = newNode;
    }
}

public boolean removeAfter(String key) {
    if (IsEmpty()) {
        System.out.println("Linked list kosong. Tidak ada data yang bisa dihapus.");
        return false;
    }

    Node16 current = head;
    while (current != null && !current.data.nim.equals(key)) {
        current = current.next;
    }

    if (current == null) {
        System.out.println("Node dengan NIM " + key + " tidak ditemukan.");
        return false;
    }

    if (current.next == null) {
        System.out.println("Tidak ada node setelah NIM " + key + " yang bisa dihapus.");
        return false;
    }

    Node16 nodeToRemove = current.next;

    current.next = nodeToRemove.next;

    if (nodeToRemove.next != null) {
        nodeToRemove.next.prev = current;
    } else {
        tail = current;
    }

    nodeToRemove.prev = null;
    nodeToRemove.next = null;


    System.out.println("Node setelah NIM " + key + " berhasil dihapus.");
    return true;
}

 public void remove(int index) {
    if (IsEmpty()) {
        System.out.println("List kosong, tidak bisa menghapus.");
        return;
    }

    if (index < 0) {
        System.out.println("Indeks tidak valid! Masukkan angka mulai dari 0.");
        return;
    }

    Node16 current = head;
    int currentIndex = 0;

    while (current != null && currentIndex < index) {
        current = current.next;
        currentIndex++;
    }

    if (current == null) {
        System.out.println("Indeks melebihi jumlah data.");
        return;
    }

    Mahasiswa16 dataDihapus = current.data;

    if (current == head && current == tail) {
        head = tail = null;
    } else if (current == head) {
        head = current.next;
        head.prev = null;
    } else if (current == tail) {
        tail = current.prev;
        tail.next = null;
    } else {
        current.prev.next = current.next;
        current.next.prev = current.prev;
    }

    System.out.println("Data berhasil dihapus. Berikut data yang terhapus:");
    dataDihapus.tampil();
}

public void getFirst() {
    if (IsEmpty()) {
        System.out.println("List kosong.");
    } else {
        System.out.println("Data pada node pertama:");
        head.data.tampil();
    }
}

public void getLast() {
    if (IsEmpty()) {
        System.out.println("List kosong.");
    } else {
        System.out.println("Data pada node terakhir:");
        tail.data.tampil();
    }
}

public void getIndex(int index) {
    if (IsEmpty()) {
        System.out.println("List kosong.");
        return;
    }

    if (index < 0) {
        System.out.println("Indeks tidak boleh negatif.");
        return;
    }

    Node16 current = head;
    int counter = 0;
    while (current != null && counter < index) {
        current = current.next;
        counter++;
    }

    if (current == null) {
        System.out.println("Indeks " + index + " tidak ditemukan.");
    } else {
        System.out.println("Data pada indeks ke-" + index + ":");
        current.data.tampil();
    }
}

public int size() {
    int count = 0;
    Node16 current = head;
    while (current != null) {
        count++;
        current = current.next;
    }
    return count;
    }
}