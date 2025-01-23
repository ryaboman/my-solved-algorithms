package stepic;

public final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public int hashCode(){
        return Double.valueOf(this.re).hashCode() + Double.valueOf(this.im).hashCode();
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof ComplexNumber)) return false;
        ComplexNumber cxNum = (ComplexNumber)obj;

        boolean statusRe = Double.valueOf(this.re).equals(cxNum.getRe());
        boolean statusIm = Double.valueOf(this.im).equals(cxNum.getIm());

        if((statusRe == statusIm) && statusRe==true ){
            return true;
        }

        return false;
    }
}
