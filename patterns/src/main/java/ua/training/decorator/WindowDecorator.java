package ua.training.decorator;

/**
* Created by Roman on 27.11.2016.
*/
abstract class WindowDecorator implements Window {
    protected Window windowToBeDecorated;

    public WindowDecorator (Window windowToBeDecorated) {
        this.windowToBeDecorated = windowToBeDecorated;
    }
    public void draw() {
        windowToBeDecorated.draw();
    }
    public String getDescription() {
        return windowToBeDecorated.getDescription();
    }
}
