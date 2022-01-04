package com.example.java_spring.basic_dependency_loosely_coupled;

public class Girl {

    private Outfit outfit;

    public Girl(Outfit anything) {
        this.outfit = anything; // Tạo ra một cô gái, với một món đồ tùy biến
        // Không bị phụ thuộc quá nhiều vào thời điểm khởi tạo, hay code
    }

    public void Show() {
        outfit.wear();
    }
}
