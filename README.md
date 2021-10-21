# TodoAppWalkthrough

A simple todo app, which follows our MVVM JavaFX architecture.

I'm doing a video tutorial. YouTube link to be attached later.

This time I've tried to use different branches, so you can see for each video part what the code looks like. 
This is because I imagine I'll make code cleanups/refactorings along the way.

Current status:

Master branch: covers videos part 1-3, i.e. viewing all todos, and adding new todos.

ChangeStatus branch: how to update a todo's status from not completed to completed.

Update branch: how to edit a todo

ValidationAndRefactoring: In this branch I introduced a new layer between ViewModels and the TodoService (now renamed to DataAccess). This layer is responsible for data validation.

Popup branch: how to make a small popup to show error/success messages and the like.
