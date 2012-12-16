package com.fablesslabs.metadata.entitydefinition;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author sabari
 */
public class EntityParser {


    /**
     * Parses the entity group(s) that are present in the directory of file. If the argument
     * is a directory, it parses all .xml files in the directory.
     *
     * @param directoryOrFile the location (file or directory) in which entity group definitions live
     * @return the set of entity groups parsed
     */
    public static Set<EntityGroup> parse(File directoryOrFile) throws IOException, EntityParseException, XMLStreamException {
        Iterator<FileInputStream> files = readFileOrDir(directoryOrFile);
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        Set<EntityGroup> entityGroups = new HashSet<EntityGroup>();
        while (files.hasNext()) {
            FileInputStream file = files.next();
            try {
                XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(file);
                entityGroups.add(parseEntityGroup(reader));
            } catch (XMLStreamException xmle) {
                System.out.println("Encountered exception while parsing file:" + file.toString());
            }
        }
        return entityGroups;
    }

    private static EntityGroup parseEntityGroup(XMLStreamReader reader) throws XMLStreamException, EntityParseException {
        int level = 0;
        MutableEntityGroup meg = new MutableEntityGroup();
        while(reader.hasNext()) {
          switch(reader.next()) {
              case XMLStreamConstants.START_ELEMENT:
                  if (level == 0) {
                    parseEntityGroupNameLabel(reader, meg);
                  } else if (level == 1) {

                  }
                  level++;
                  break;
          }
        }

        return meg.finish();
    }

    private static void parseEntityGroupNameLabel(XMLStreamReader reader, MutableEntityGroup meg) throws EntityParseException {
        if (!EntityGroup.NAMESPACE.equals(reader.getNamespaceURI())) {
           throw new EntityParseException("Incorrect namespace " + reader.getNamespaceURI() + ". Expecting namespace " + EntityGroup.NAMESPACE);
        }

        meg.setName(reader.getLocalName());
        meg.setLabel(reader.getAttributeValue(EntityGroup.NAMESPACE, "label"));
    }

    private static Iterator<FileInputStream> readFileOrDir(File directoryOrFile) throws IOException {
        if (!directoryOrFile.exists())
            throw new IOException("File or directory " + directoryOrFile.getAbsolutePath() + " doesn't exist");

        File[] files;
        if (directoryOrFile.isDirectory()) {
            files = directoryOrFile.listFiles(new FilenameFilter() {
                public boolean accept(File file, String name) {
                    return name.endsWith(".xml");
                }
            });
        } else {
            files = new File[]{directoryOrFile};
        }
        final Iterator<File> it = Arrays.asList(files).iterator();
        return new Iterator<FileInputStream>() {
            public boolean hasNext() {
                return it.hasNext();
            }

            public FileInputStream next() {
                try {
                    return new FileInputStream(it.next());
                } catch (FileNotFoundException e) {
                    //
                    return null;
                }
            }

            public void remove() {
            }
        };

    }
}
