package ru.eltex.home.ierarh;

import java.io.IOException;

interface CSV {
    String toCSV() throws IOException;
    void fromCSV(String str);
}
