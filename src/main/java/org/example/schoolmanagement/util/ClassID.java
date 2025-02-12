package org.example.schoolmanagement.util;

public enum ClassID {
    CLASS_1A(1),
    CLASS_1B(2),
    CLASS_1C(3),
    CLASS_1D(4),
    CLASS_2A(5),
    CLASS_2B(6),
    CLASS_2C(7),
    CLASS_2D(8),
    CLASS_3A(9),
    CLASS_3B(10),
    CLASS_3C(11),
    CLASS_3D(12),
    CLASS_4A(13),
    CLASS_4B(14),
    CLASS_4C(15),
    CLASS_4D(16),
    CLASS_5A(17),
    CLASS_5B(18),
    CLASS_5C(19),
    CLASS_5D(20),
    CLASS_6A(21),
    CLASS_6B(22),
    CLASS_6C(23),
    CLASS_6D(24),
    CLASS_7A(25),
    CLASS_7B(26),
    CLASS_7C(27),
    CLASS_7D(28),
    CLASS_8A(29),
    CLASS_8B(30),
    CLASS_8C(31),
    CLASS_8D(32),
    CLASS_9A(33),
    CLASS_9B(34),
    CLASS_9C(35),
    CLASS_9D(36),
    CLASS_10A(37),
    CLASS_10B(38),
    CLASS_10C(39),
    CLASS_10D(40),
    CLASS_11A(41),
    CLASS_11B(42),
    CLASS_11C(43),
    CLASS_11D(44);

    private final int id;

    ClassID(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name() + " (ID: " + id + ")";
    }
}
