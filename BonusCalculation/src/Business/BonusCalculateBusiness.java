package Business;

import Model.BonusUpdateModel;

public class BonusCalculateBusiness {
	
	BonusUpdateModel updatebonus = new BonusUpdateModel();

	public double inserBonus(int epf, int experience , int salary) {
		if (epf > 0  && experience > 0 && salary > 0) {
			
			
		BonusUpdateModel.insertBonus(epf, experience , salary);
				

			double bonus = CalculateBonus(salary ,experience);
			return bonus;
		} else {		

			return 0;
		}
	}
	
	public double CalculateBonus(int salary , int experience) {
		
if(experience < 2 && salary > 0 ) {
			
			return 50000;
		} 
		else if ( experience >= 2 && experience < 5 && salary < 100000 ){
			
			return salary*0.05;
		}
		else if ( experience >= 2 && experience < 5 && salary > 100000 ){
			
			return salary*0.07;
		}
		else if( experience >= 5) {
			
			return salary*0.1;}
		else 
					return 0;
		
		
	}

	public double previousBonus(int epf) {
		
		int[] items = null;
		
			items = BonusUpdateModel.previousBonus(epf);
		
		System.out.print(items);
		
		int salary = items[0];
		int experience = items[1];
		
		double bonus = CalculateBonus(salary ,experience);
		return bonus;
		
		
		
	}

}
