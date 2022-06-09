package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class Piesa22Tile extends Tile{
    public Piesa22Tile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.piesa22, id);
    }

    /*! \fn public boolean IsSolid()
        \brief Suprascrie metoda IsSolid() din clasa de baza in sensul ca va fi luat in calcul in caz de coliziune.
     */
    @Override
    public boolean IsSolid()
    {
        return true;
    }

}
