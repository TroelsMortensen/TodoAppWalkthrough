# TodoAppWalkthrough

A simple todo app, which follows our MVVM JavaFX architecture.

I'm doing a video tutorial. YouTube link to be attached later.

This time I've tried to use different branches, so you can see for each video part what the code looks like. 
This is because I imagine I'll make code cleanups/refactorings along the way.

### Current status:

1. Master branch: covers videos part 1-3, i.e. viewing all todos, and adding new todos.

2. ChangeStatus branch: part 4, how to update a todo's status from not completed to completed.

3. Update branch: part 5, how to edit a todo

4. ValidationAndRefactoring: part 6, in this branch I introduced a new layer between ViewModels and the TodoService (now renamed to DataAccess). This layer is responsible for data validation.

5. Popup branch: part 7, how to make a small popup to show error/success messages and the like.

6. DeleteTodo branch: part 8, how to delete a todo from the tabel.


### Current roadmap (prioritized)
2. filtering the view of todos (use a filter object, with fluent builder)
3. refactor the open * View method in ViewHandler to one method
4. add users
5. change file storage to use json instead of binary
6. add priority to todo items.
