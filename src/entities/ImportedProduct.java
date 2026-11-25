package entities;

public class ImportedProduct extends Product {

	private Double customsFee;

	public ImportedProduct(String name, double price, double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFree(Double customsFee) {
		this.customsFee = customsFee;
	}
	
	public double totalPrice() {
		return super.getPrice() + this.customsFee;
	}
	
	@Override
	public String priceTag() {
		StringBuilder sb = new StringBuilder();
		sb.append( super.getName()+ " $ " );
		sb.append( String.format("%.2f", totalPrice()) );
		sb.append("(Customs fee: $ ");
		sb.append(String.format("%.2f", getCustomsFee()));
		sb.append(")");
		return sb.toString();
	}

}
