# VariantSync-SPLC-16-Example-Workspace
Complete workspace that was used during the demonstration of VariantSync at SPLC'16 in Beijing, China

## VariantSync Demo

This is an example for [VariantSync][1]. 
The following instructions are a guide for this example.
For a step by step guide please consider the available [screencasts][2].

0. Import all projects into your Eclipse Workspace.
All Notepad projects should be marked as VariantSync projects (![little green V icon](VariantSyncSupport.png "VariantSyncIcon")) except for NotepadH.
You might want to switch to the VariantSync perspective to open all necessary windows for the following examples.
1. Run variants A to D. You will see different implementations of notebooks, which are already developed with VariantSync.
2. Open the feature model in the `variantsyncFeatureInfo` project.
3. Create a new configuration `NotepadH` with the features `FormatRaw` and `Undo` in `variantsyncFeatureInfo/configs`.
4. Right click project `NotepadH` and click `Configure > Add As Variant` to enable VariantSync support for this project.
5. First example:
   * Set the context to `TextStyled` and start recording.
   * Open the `Notepad.java` in variant B. 
   * After line 252, add a new line with the following content: ``textPane.setText("Hello VariantSync users");``.
     When saving the file you will see the line annotated with feature `TextStyled`.
     As variant B is the only feature implementing this feature (visible in the `Configuration Map`) no synchronization has to be performed.
   * Stop recording.
6. Second example:
   * Set the context to `Toolbar` and start recording.
   * Open the `Notepad.java` in variant `C`.
   * In line 331, change the string `North` to `South`.
   * Compare variants `C` and `E` with the Eclipse compare view.
   * Open the `Notepad.java` in variant `E`.
   * Synchronize the variants with the source-focused view.
   * Look at the corresponding line of the `Notepad.java` in variant `E`
7. Third example:
   * Set the context to `Undo` and start recording.
   * Open the `UndoAction.java` in variant `E`.
   * Change the super call in the constructor from `Undo` to `Undo Edit`.
   * Synchronize the variants with the source-focused view.
   * Look at the results in variants `A`,`C`, and `F` (As NotepadH does not have feature `MenuBar` the change is not visible in the application). You can see all configurations implementing a feature in the configuration map of FeatureIDE.
8. Fourth example:
   * Set the context to `Base` and start recording.
   * Open the `Notepad.java` in any variant.
   * In the constructor, change the value `300` to `400`.
   * Synchronize the variants with the source-focused view.
   * Look at the results in variants with and without merge conflicts.
 
### Instructions for Resproductions of the [Screencast][2]

- [Video 2 (Setting-Up Legacy Clones for Synchronization)][3]: Please checkout the branch `screencast_video2`. At the end of the video you will see the project in a state like in the `master` branch.

[1]: https://github.com/tthuem/VariantSync
[2]: https://www.youtube.com/playlist?list=PLBZnGZWZgEBZ8Me6WDQGdQRg438_Z4sl_
[3]: https://www.youtube.com/watch?v=zesWRaCCM7E&list=PLBZnGZWZgEBZ8Me6WDQGdQRg438_Z4sl_&index=2