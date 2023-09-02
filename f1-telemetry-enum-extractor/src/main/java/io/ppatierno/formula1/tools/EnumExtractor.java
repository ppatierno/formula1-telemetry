/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class EnumExtractor {

    public static void main(String[] args) throws IOException {

        if (args.length < 2) {
            throw new IllegalArgumentException("Missing arguments");
        }

        // input file in CSV with format: ID,NAME
        String inFilePath = args[0];
        // output file as Java enum values declaration
        String outFilePath = args[1];

        BufferedReader reader = new BufferedReader(new FileReader(inFilePath));
        FileWriter writer = new FileWriter(outFilePath);

        String line = reader.readLine();
        while (line != null) {
            String[] tokens = line.split(",");
            int id = Integer.parseInt(tokens[0]);
            String name = tokens[1]
                    // remove all the kind of apostrophes
                    .replace("\u2018", "")
                    .replace("\u2019", "")
                    .replace("\u201A", "")
                    .replace("\u201B", "")
                    .replace("\u2027", "")
                    .replace("\u2032", "")
                    .replace(" ", "_")
                    .replace("-", "_")
                    .toUpperCase(Locale.ROOT);
            System.out.println("id = " + id + " name = " + name);

            String out = String.format("%s(%d),\n", name, id);
            writer.write(out);

            line = reader.readLine();
        }
        reader.close();
        writer.close();
    }
}
