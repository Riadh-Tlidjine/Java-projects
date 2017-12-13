import java.lang.System.*;
public class Jeu{

    public static void main(String[] args){
    		 int nbpommes=15;
    		 	int nbc= 6;
    		 	int nbkiwis=5; //question 16


/*
	Pomme p1 = new Pomme();
	Pomme p2 = new Pomme();
	Sac s = new Sac(5);
	s.ajouter(p1);
	s.ajouter(p2);

	
	System.out.println(s.toString());

	Creature c1 = new Creature();
    c1.courir();
    	Pomme p3 = new Pomme();
    	s.ajouter(p3);
        c1.ajouteacc(p1);
        c1.ajouteacc(p2);
        c1.ajouteacc(p3);
        c1.courir();
        c1.manger();
        c1.manger();
        c1.manger();
        c1.courir();


    Creature c2 = new Creature();
    Monde m = new Monde(6);
    Avatar a1 = new Avatar("Riadh",70,m);
    Avatar a2 = new Avatar("xander",99,m);

   	m.ajouterItem(c1);
   	m.ajouterItem(c2);

   	m.ajouterItem(p1);
   	m.ajouterItem(p2);
	m.ajouterItem(p3);
        
    m.ajouterItem(a1);

    m.afficher();

    a1.course();
    while(true){
	a1.seDeplacer();
    a2.seDeplacer();
	m.afficher();
	}
	*/
	//QUESTION 15
	 //int nbpommes=15;
	//int nbkiwis = 15;

	//int nbc= 6;

	Monde m2 = new Monde(9);
	Avatar a1 = new Avatar("Riadh",70,m2);
    Avatar a2 = new Avatar("xander",99,m2);
	
	Pomme [] p=new Pomme[nbpommes];
	Creature [] c = new Creature[nbc];
	Kiwi[] K=new Kiwi[nbkiwis];//question 16

	Creature2 c17 = new Creature2(); //Question 17
	m2.ajouterItem(c17); //Question 17

	for( int i=0; i<nbpommes; i++){

		p[i]= new Pomme();
		m2.ajouterItem(p[i]);
		if (i<nbc) {
			c[i]=new Creature();
			m2.ajouterItem(c[i]);
		}
		if (i<nbkiwis){
            K[i]=new Kiwi();
            m2.ajouterItem(K[i]);
        }    


		}

	for(int i =0; i< 5; i++){
            m2.afficher();
            
            a1.seDeplacer();
            a1.rencontrerVoisins();
            m2.afficher();
            a1.ameliorer();//question 18
            
            a2.seDeplacer();
            a2.rencontrerVoisins();
            m2.afficher();
            a2.ameliorer();//question 18
           
            System.out.println("Fin du tour "+(i+1));
        }
            if (a1.course() > a2.course()){
                System.out.println(String.format("%s gagne la course ! Distance parcouru : %.2f km", a1.getNom(), a1.course()));
            }
            else {
                System.out.println(String.format("%s gagne la course ! Distance parcouru : %.2f km", a2.getNom(), a2.course()));
            }

        
        
        

       
    }
	}

    

    



        	   
       
    