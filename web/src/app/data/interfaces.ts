interface Weapon {
  weaponEffectiveness?: Effectiveness[];
  ammunitionType?: string;
  gunReach?: number;
  image?: string;
  id?: number;
  name?: string;
}

interface Area {
  creatures?: Creature[];
  id?: number;
  name?: string;
  description?: string;
  image?: string;
}

interface Creature {
  areas?: Area[];
  weaponEffectiveness?: Effectiveness[];
  image: string;
  name: string;
  agility: number;
  weight: number;
  height: number;
  id?: number;
}

interface User {
  posts?: Effectiveness[];
  image?: any;
  id: number;
  username?: string;
  email?: string;
  name?: string;
  admin: boolean;
}

interface Effectiveness {
  rating?: number;
  id?: number;
  author?: User;
  weapon?: Weapon;
  creature?: Creature;
}

