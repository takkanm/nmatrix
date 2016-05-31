import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.linear.ArrayFieldVector;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.linear.FieldVector;

public class NMatrix{

	private int shape;
	public ArrayRealVector realArray;
	private String dtype_string;
	private String stype_string;

	private Dense_Storage storage;
	
	public String get_stype_string(){
		return this.stype_string;
	}


  private Stype stype;
  private Dtype dtype;

	// NMatrix(shape, elements, dtype, stype)
	public NMatrix(int shape, double[] elements, Dtype dtype, Stype stype){
		this.shape = shape;
		this.realArray = new ArrayRealVector(elements);
		this.dtype = dtype;

		// if(this.checkVectorDimensions(2)){
		// 	//we have a double matrix
		// }

		switch(stype){
			case DENSE_STORE:
				this.stype_string = "dense";
				// (int dim, int[] shape, String dtype, int offset, int count, double[] elements)
				// this.storage = new Dense_Storage( 2,new int[]{2,3}, "int", 1, 4, elements);
				break;
			case LIST_STORE:
				this.stype_string = "list";
				break;
			case YALE_STORE:
				this.stype_string = "yale";
				break;
			default:
				this.stype_string ="stype could not be determined";
				break;
		}

		switch(dtype){
			case BYTE:
				this.dtype_string = "BYTE";
				break;
			case INT8:
				this.dtype_string = "INT8";
				break;
			case INT16:
				this.dtype_string = "INT16";
				break;
			case INT32:
				this.dtype_string = "INT32";
				break;
			case INT64:
				this.dtype_string = "INT64";
				break;
			case FLOAT32:
				this.dtype_string = "FLOAT32";
				break;
			case FLOAT64:
				this.dtype_string = "FLOAT64";
				break;
			case COMPLEX64:
				this.dtype_string = "COMPLEX64";
				break;
			case COMPLEX128:
				this.dtype_string = "COMPLEX128";
				break;
			case RUBYOBJ:
				this.dtype_string = "RUBYOBJ";
				break;
		}
	}

	// public NMatrix(int shape, double[] elements, Dtype dtype){
	// 	this(shape, elements, dtype, Stype.DENSE_STORE);
	// }

	// public NMatrix(int shape, double[] elements){
	// 	this(shape, elements,  Dtype.FLOAT32, Stype.DENSE_STORE);
	// }

	


	public static NMatrix aret(NMatrix a){
			return a;
	}

	// ArrayRealVector add(RealVector v)
	// Compute the sum of this vector and v.

	public NMatrix add(NMatrix n){
		ArrayRealVector resRealArray =  this.realArray.add(n.realArray);
		NMatrix res = new NMatrix(2, resRealArray.toArray(), Dtype.FLOAT32, Stype.DENSE_STORE);
		return res;
	}

	// void	addToEntry(int index, double increment)
	// Change an entry at the specified index.

	public void addToEntry(int index, double increment){
		this.realArray.addToEntry(index, increment);
	}


	// ArrayRealVector	append(ArrayRealVector v)
	// Construct a vector by appending a vector to this vector.

	public NMatrix append(NMatrix n){
		RealVector resRealArray =  this.realArray.append(n.realArray);
		NMatrix res = new NMatrix(2, resRealArray.toArray(), Dtype.FLOAT32, Stype.DENSE_STORE);
		return res;
	}


	// RealVector	append(double in)
	// Construct a new vector by appending a double to this vector.

	public NMatrix append(double in){
		RealVector resRealArray =  this.realArray.append(in);
		NMatrix res = new NMatrix(2, resRealArray.toArray(), Dtype.FLOAT32, Stype.DENSE_STORE);
		return res;
	}


	// RealVector	append(RealVector v)
	// Construct a new vector by appending a vector to this vector.
		 
		//ignored

	// protected void	checkVectorDimensions(int n)
	// Check if instance dimension is equal to some expected value.

		// protected void checkNMatrixDimensions(int n){
		// 	this.realArray.checkVectorDimensions(n);
		// }


	// protected void	checkVectorDimensions(RealVector v)
	// Check if instance and specified vectors have the same dimension.

		//ignored

	// ArrayRealVector	combine(double a, double b, RealVector y)
	// Returns a new vector representing a * this + b * y, the linear combination of this and y.

	// ArrayRealVector	combineToSelf(double a, double b, RealVector y)
	// Updates this with the linear combination of this and y.
	// ArrayRealVector	copy()
	// Returns a (deep) copy of this vector.
	// double	dotProduct(RealVector v)
	// Compute the dot product of this vector with v.
	// ArrayRealVector	ebeDivide(RealVector v)
	// Element-by-element division.
	// ArrayRealVector	ebeMultiply(RealVector v)
	// Element-by-element multiplication.
	// boolean	equals(Object other)
	// Test for the equality of two real vectors.
	// double[]	getDataRef()
	// Get a reference to the underlying data array.

	// int	getDimension()
	// Returns the size of the vector.

	public int getDimension(){
		return this.realArray.getDimension();
	}

	// double	getDistance(RealVector v)
	// Distance between two vectors.

	// double	getEntry(int index)
	// Return the entry at the specified index.
	public double getEntry(int index){
		return this.realArray.getEntry(index);
	}

	// double	getL1Distance(RealVector v)
	// Distance between two vectors.

	// double	getL1Norm()
	// Returns the L1 norm of the vector.

	public double getL1Norm(){
		return this.realArray.getL1Norm();
	}

	// double	getLInfDistance(RealVector v)
	// Distance between two vectors.

	// public double getLInfDistance()

	// double	getLInfNorm()
	// Returns the L∞ norm of the vector.

	public double getLInfNorm(){
		return this.realArray.getLInfNorm();
	}

	// double	getNorm()
	// Returns the L2 norm of the vector.

	public double getNorm(){
		return this.realArray.getNorm();
	}

	// RealVector	getSubVector(int index, int n)
	// Get a subvector from consecutive elements.

		// public 

	// int	hashCode()
	// .
	public int hashCode(){
		return this.realArray.hashCode();
	}

	// boolean	isInfinite()
	// Check whether any coordinate of this vector is infinite and none are NaN.

	public boolean isInfinite(){
		return this.realArray.isInfinite();
	}

	// boolean	isNaN()

	public boolean isNaN(){
		return this.realArray.isNaN();
	}

	// Check if any coordinate of this vector is NaN.
	// ArrayRealVector	map(UnivariateFunction function)
	// Acts as if implemented as:

		// public NMatrix map(UnivariateFunction function){
		// 	// NMatrix res = new NMatrix(2, new double[]{2,3,4,5}, Dtype.FLOAT32, Stype.DENSE_STORE)
		// }


	// RealVector	mapAddToSelf(double d)
	// Add a value to each entry.



	// RealVector	mapDivideToSelf(double d)
	// Divide each entry by the argument.



	// RealVector	mapMultiplyToSelf(double d)
	// Multiply each entry.



	// RealVector	mapSubtractToSelf(double d)
	// Subtract a value from each entry.




	// ArrayRealVector	mapToSelf(UnivariateFunction function)
	// Acts as if it is implemented as:




	// RealMatrix	outerProduct(RealVector v)
	// Compute the outer product.




	// void	set(double value)
	// Set all elements to a single value.
	public void set(double value){
		this.realArray.set(value);
	}


	// void	setEntry(int index, double value)
	// Set a single element.

	public void setEntry(int index, double value){
		this.realArray.setEntry(index,value);
	}

	// void	setSubVector(int index, double[] v)
	// Set a set of consecutive elements.

	public void setSubVector(int index, double[] v){
		this.realArray.setSubVector(index, v);
	}

	// void	setSubVector(int index, RealVector v)
	// Set a sequence of consecutive elements.

	public void setSubVector(int index, RealVector v){
		this.setSubVector(index, v);
	}

	// ArrayRealVector	subtract(RealVector v)
	// Subtract v from this vector.

	// public NMatrix subtract(NMatrix N){
	// 	// NMatrix res = NMatrix new(2, this.realArray.subtract(N.realArray), Dtype.FLOAT32, Stype.DENSE_STORE);
	// }

	// Convert the vector to an array of doubles.
	// double[]	toArray()
	public double[] toArray(){
		return this.realArray.toArray();
	}


// String	toString()
	public String toString(){
		return this.realArray.toString();
	}

	// double	walkInDefaultOrder(RealVectorChangingVisitor visitor)
	// Visits (and possibly alters) all entries of this vector in default order (increasing index).
	// double	walkInDefaultOrder(RealVectorChangingVisitor visitor, int start, int end)
	// Visits (and possibly alters) some entries of this vector in default order (increasing index).
	// double	walkInDefaultOrder(RealVectorPreservingVisitor visitor)
	// Visits (but does not alter) all entries of this vector in default order (increasing index).
	// double	walkInDefaultOrder(RealVectorPreservingVisitor visitor, int start, int end)
	// Visits (but does not alter) some entries of this vector in default order (increasing index).
	// double	walkInOptimizedOrder(RealVectorChangingVisitor visitor)
	// Visits (and possibly alters) all entries of this vector in optimized order.
	// double	walkInOptimizedOrder(RealVectorChangingVisitor visitor, int start, int end)
	// Visits (and possibly change) some entries of this vector in optimized order.
	// double	walkInOptimizedOrder(RealVectorPreservingVisitor visitor)
	// Visits (but does not alter) all entries of this vector in optimized order.
	// double	walkInOptimizedOrder(RealVectorPreservingVisitor visitor, int start, int end)
	// Visits (but does not alter) some entries of this vector in optimized order.

}