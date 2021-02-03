# ScanaBrigo
Un ripasso comprensivo di Java per il 2020 (for my homies)
### Features
* Gestione di un elenco: caricamento ed eliminazione (il renderng della JTable dopo un' eliminazione è buggato, fatevene una ragione)
* ArrayList
* Visualizzazione elenco attraverso una JTable
* JComboBox, JOptionPane (input e messaggi), JDialog che si interfaccia con l'oggetto Database
* GridBagLayout, GridLayout
* Salvataggio e caricamento in file serializable e di testo (Dal menù, utilizzo di JOptionPane per il filename)
* Overcasting
* Interfacce
* Factory Pattern 
* Enum

### Weaknesses
* Handling delle eccezioni un po' spartano (appare solo un mesaggio di errore)
* Non ci sono commenti al codice
### Note
Se specificate durante il salvataggio un filename senza path verrà probabilmente salvato nella cartella del vostro progetto (non src, la parent).
Inoltre, salvare su file che non esistono dovrebbe crearli, se non succede e si verificano errori nel salvataggio, provate prima a farlo manualmente.
Sulla mia versione di Eclipse non ho riscontrato problemi 
>Eclipse IDE for Java Developers
>Version: 2019-12 (4.14.0)
>Build id: 20191212-1212
>OS: Ubuntu 20.01, Linux 5.4.0-52-generic x64
### Authors:
* [MatMasIt](https://github.com/DiegoS2003)
* [DiegoS2003](https://github.com/DiegoS2003)
