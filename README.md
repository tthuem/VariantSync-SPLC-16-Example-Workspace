# VariantSync-SPLC-16-Example-Workspace
Complete workspace that was used during the demonstration of VariantSync at SPLC'16 in Beijing, China

## VariantSync Demo

This is an example for [VariantSync](https://github.com/tthuem/VariantSync).  
The following instructions are a guide for this example.

0. Clone this repository and switch the Eclipse workspace to the repository folder.
1. Run variants A to D. You will see different implementations of notebooks, which are already developed with VariantSync.
2. Open the feature model in the `variantsyncFeatureInfo` project.
3. Create a new configuration `NotepadH` with the following features: `FormatRaw`, `Undo`
4. Add the VariantSync tool support to the already existing variant `NotepadH`
5. First example:
   * Set the context to `TextStyled`.
   * Open the `Notepad.java` in variant `B`. 
   * After line 252, add a new line with the following content: ``textPane.setText("Hello VariantSync users")``
6. Second example:
   * Set the context to `Toolbar`.
   * Open the `Notepad.java` in variant `C`.
   * In line 331, change the string `North` to `South`.
   * Compare variants `C` and `E` with the Eclipse compare view.
   * Open the `Notepad.java` in variant `E`.
   * Synchronize the variants with the source-focused view.
   * Look at the corresponding line of the `Notepad.java` in variant `E`
7. Third example:
   * Set the context to `Undo`.
   * Open the `UndoAction.java` in variant `E`.
   * Change the super call in the constructor from `Undo` to `Undo Edit`.
   * Synchronize the variants with the source-focused view.
   * Look at the results in e.g. variants `A`,`C`,`F` (you can see all configurations implementing a feature in the configuration map of FeatureIDE)
8. Fourth example:
   * Set the context to `Base`
   * Open the `Notepad.java` in any variant.
   * In line 306, change the value `300` to `400`.
   * Synchronize the variants with the source-focused view.
   * Look at the results in variants with and without merge conflicts.
 
