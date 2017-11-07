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
   * Start the recording with context `TextStyled`.
   * Open the `Notepad.java` in variant `B`.
   * After line 252, add a new line with the following content: ``textPane.setText("Hello VariantSync users")``.
   * Save the file.
   * Run variant `B` to see the result of the change.
   * Open the Configuration Map. You will see that no other Variant implements `TextStyled`.
   * Open the Resource Changes View. You will see no other targets for the change.
6. Second example:
   * Switch the context to `Toolbar`.
   * Open the `Notepad.java` in variant `C`.
   * In line 331, change the string `North` to `South` and save the file.
   * Run variant `C` to see the result of the change.
   * Compare variants `C` and `E` with the Eclipse compare view.
   * Open the `Notepad.java` in variant `E`.
   * Synchronize the variants with the source-focused view.
   * Look at the corresponding line of the `Notepad.java` in variant `E`
7. Third example:
   * Switch the context to `Undo`.
   * Open the `UndoAction.java` in variant `E`.
   * Change the super call in the constructor from `Undo` to `Undo Edit` and save the file.
   * Run variant `E` to see the result of the change.
   * Synchronize the variants `A`, `C` and `F` with the source-focused view.
   * Look at the results in variants `A`,`C`,`F`.
8. Fourth example:
   * Switch the context to `Base`
   * Open the `Notepad.java` in variant `A`.
   * In line 153, change the value `300` to `400`, save the file and stop recording.
   * Run variant `A` to see the result of the change.
   * Synchronize the variant `H` with the target-focused view.
   * Look at the results in variant `H`.
 
